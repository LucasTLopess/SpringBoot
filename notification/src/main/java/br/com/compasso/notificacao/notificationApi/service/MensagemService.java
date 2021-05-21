package br.com.compasso.notificacao.notificationApi.service;


import br.com.compasso.notificacao.notificationApi.model.Cliente;
import br.com.compasso.notificacao.notificationApi.model.Mensagem;
import br.com.compasso.notificacao.notificationApi.repository.MensagemRepository;
import br.com.compasso.notificacao.notificationApi.configuration.ConfigRabbitMQ;
import br.com.compasso.notificacao.notificationApi.dto.PedidoMensagemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MensagemService {


    @Autowired
    MensagemRepository mensagemRepository;
    @Autowired
    ConsumeAPICliente consumeAPICliente;


    Logger logger = LoggerFactory.getLogger(MensagemService.class);


    public List<Mensagem> listarTodas() {
        logger.info("Listando todas as mensagens");
        return mensagemRepository.findAll();
    }

    public ResponseEntity<Mensagem> listarPorId(Long id) {
        logger.info("Lintando mensagem" + id);
        return ResponseEntity.ok().body(mensagemRepository.findById(id).get());
    }

    public Mensagem enviarMensagem(Mensagem mensagem) {


        Cliente cliente = new Cliente();

        try {
            logger.info("Invocando serviço para consumir API Clientes");
            cliente = consumeAPICliente.consumeAPI(mensagem.getId_Cliente());
        } catch (Exception e) {
            logger.error("Erro ao realizar a busca na API Clientes com o id: " + mensagem.getId_Cliente());
            return null;
        }

        switch (cliente.getPreferencia()) {
            case "email":
                try {
                    logger.info("Invocando Seviço de Email");
                    EmailService emailService = new EmailService();
                    emailService.enviaEmail(mensagem.getMensagem(), cliente.getEmail());

                } catch (Exception e) {
                    try {
                        logger.info("Invocando serviço de SMS");
                        SmsService smsService = new SmsService();
                        smsService.enviaSms(mensagem.getMensagem(), cliente.getTelefone());
                    } catch (Exception i) {
                        logger.error("Erro ao enviar mensagem para o cliente");
                        return null;
                    }
                }
                break;
            case "SMS":
                try {
                    logger.info("Invocando serviço de SMS");
                    SmsService smsService = new SmsService();
                    smsService.enviaSms(mensagem.getMensagem(), cliente.getEmail());
                } catch (Exception i) {
                    logger.error("Erro ao enviar mensagem para o cliente");
                    try {
                        logger.info("Invocando Seviço de Email");
                        EmailService emailService = new EmailService();
                        emailService.enviaEmail(mensagem.getMensagem(), cliente.getTelefone());

                    } catch (Exception e) {
                        logger.error("Erro ao enviar mensagem para o cliente");
                        return null;
                    }
                }
                break;
            default:
                logger.error("Não foi possivel enviar a mensagem a nenhum dos contatos do Cliente");
                return null;
        }

        return mensagemRepository.save(mensagem);

    }

    @RabbitListener(queues = ConfigRabbitMQ.QUEUE)
    public void recebeMensagemRabbitMQ(@Payload PedidoMensagemDto pedidoMensagemDto){
        Mensagem mensagem = new Mensagem();
        mensagem.setMensagem(pedidoMensagemDto.getMensagem());
        mensagem.setId_Cliente(pedidoMensagemDto.getIdCliente());
        enviarMensagem(mensagem);
    }

    public String deletarPorId(Long id) {
        logger.info("Verificando mensagem:" + id);
        if (mensagemRepository.existsById(id) == true) {
            logger.warn("Deletando mensagem ID" + id);
            mensagemRepository.deleteById(id);
            return "A mensagem de id: " + id + " foi deletada com sucesso";
        } else {
            logger.error("A mensagem :" + id + " não existe");
            return "A mensagem de id: " + id + " n'ao existe em nossa base de dados";
        }

    }
}
