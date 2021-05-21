//package br.com.compasso.notificacao.notificationApi.intregado.repository;
//
//import br.com.compasso.notificacao.notificationApi.model.Mensagem;
//import br.com.compasso.notificacao.notificationApi.repository.MensagemRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MensagemRepositoryTest {
//
//    @Autowired
//    private MensagemRepository mensagemRepository;
//
//    @Test
//    public void deveriaBuscarPorIdMensagem(){
//        Long id = new Long(1);
//        Optional<Mensagem> mensagem = mensagemRepository.findById(id);
//        Assert.assertNotNull(mensagem);
//    }
//    @Test
//    public void deveriaBuscarTodasMensagens(){
//        List<Mensagem> mensagem = mensagemRepository.findAll();
//        Assert.assertNotNull(mensagem);
//    }
//    @Test
//    public void deveriaEnviarMensagem(){
//        Mensagem mensagem1 = new Mensagem();
//        mensagem1.setId_Cliente("1");
//        mensagem1.setMensagem("Realizado com sucesso");
//        Mensagem mensagem = mensagemRepository.save(mensagem1);
//        Assert.assertNotNull(mensagem);
//    }
//    @Test
//    public void  deveriaDeletarMensagemPorId(){
//        Long id = 5l;
//        String deuCerto = "";
//        if(mensagemRepository.existsById(id) == true) {
//            mensagemRepository.deleteById(id);
//            deuCerto ="A mensagem "+ id + " foi deletada com sucesso";
//        }
//        Assert.assertEquals("A mensagem "+ id + " foi deletada com sucesso", deuCerto);
//    }
//    @Test
//    public void deveriaNãoSalvarMesangemVazia(){
//
//        Mensagem mensagem = new Mensagem();
////        mensagem.setMensagem("Deveria enviar mensagem");
////        mensagem.setId_Cliente(2L);
//
//
//
//    }
//
//}