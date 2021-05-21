package br.com.compasso.notificacao.notificationApi.intregado.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MensagemServiceTest {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void TestaEnvioDeEmail(){
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("teste@gmail.com");
        email.setSubject("Teste envio de e-mail");
        email.setText("Enviei este e-mail usando Spring Boot.");
        mailSender.send(email);
    }
    @Test
    public void TestaEnvioDeSms(){
        final String ACCOUNT_SID =    "ACfea9cd549bb7be7e7f9ae4b84096284f";
        final String AUTH_TOKEN =     "b25cce86aa3f13a99e22f84a65a54167";

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber("+5548998411531"),
                new PhoneNumber("+5162199912"),
                "Sample Twilio SMS using Java")
                .create();
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testandoRequisicaoPostEnvioMensagem() throws Exception {
        URI uri = new URI("/mensagem/enviar");
        String json = "{\"id_Cliente\":\"6010602edec9b27db236975a\" , \"mensagem\":\"testando mock\"}";

        mockMvc
                .perform(MockMvcRequestBuilders.post(uri)
                        .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(202));
    }

    }

