package br.com.compasso.notificacao.notificationApi.unitario;

import br.com.compasso.notificacao.notificationApi.model.Mensagem;
import br.com.compasso.notificacao.notificationApi.service.MensagemService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnviarMensagemTest {

    @Test
    public void enviaMensagem() {

        Mensagem mensagem = new Mensagem();
        mensagem.setMensagem("Oi");
        mensagem.setId_Cliente("123123");

        MensagemService mensagemServiceMock = Mockito.mock(MensagemService.class);
        Mensagem mensagem1 = mensagemServiceMock.enviarMensagem(mensagem);

        Assert.assertNull(mensagem1);
    }
}
