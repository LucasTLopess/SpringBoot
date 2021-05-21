package br.com.compasso.notificacao.notificationApi.unitario;

import br.com.compasso.notificacao.notificationApi.configuration.ClietesURL;
import br.com.compasso.notificacao.notificationApi.mocker.configuration.ClietesURLTest;
import br.com.compasso.notificacao.notificationApi.model.Cliente;
import br.com.compasso.notificacao.notificationApi.service.ConsumeAPICliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumirApiTest {

    @Autowired
    ClietesURLTest clietesURLTest;

    @Test
    public void ComsumirApiTest(){

        UriComponents UriMock = clietesURLTest.consomeApi();

        ConsumeAPICliente consumeAPICliente = Mockito.mock(ConsumeAPICliente.class);

        Cliente cliente = consumeAPICliente.consumeAPI("123");
     
    }

}
