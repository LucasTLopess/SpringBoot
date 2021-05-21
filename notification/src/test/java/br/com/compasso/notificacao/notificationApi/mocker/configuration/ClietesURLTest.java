package br.com.compasso.notificacao.notificationApi.mocker.configuration;

import br.com.compasso.notificacao.notificationApi.configuration.ClietesURL;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClietesURLTest {

    @Test
    public UriComponents consomeApi(){
        ClietesURL mockUrl = Mockito.mock(ClietesURL.class);
        UriComponents UriMock = mockUrl.criarUri("123");
        Assert.assertEquals(null ,UriMock);
        return UriMock;
    }

}