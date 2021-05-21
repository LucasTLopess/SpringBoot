package br.com.compasso.notificacao.notificationApi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {

    Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public boolean enviaEmail(String mensagem, String clienteEmail){

        SimpleMailMessage emailModelo = new SimpleMailMessage();
        emailModelo.setTo(clienteEmail);
        emailModelo.setSubject("Compra realizada na API Pedido. ");
        emailModelo.setText(mensagem);

        try {
            logger.info("Enviando Email para Cliente");
            mailSender.send(emailModelo);
            return true;
        }catch (Exception e){
            logger.error("Erro ao enviar Email");
            return false;
        }
    }

}
