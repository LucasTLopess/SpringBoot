package br.com.compasso.notificacao.notificationApi.intregado.service;

import br.com.compasso.notificacao.notificationApi.configuration.ClientesApiConfiguration;
import br.com.compasso.notificacao.notificationApi.model.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumeAPIClienteTest {

    @Autowired
    ClientesApiConfiguration clientesApiConfiguration;

//    @Test
//    public void ConsomeApiCliente(){
//        RestTemplate template = new RestTemplate();
//        String id = "6010602edec9b27db236975a";
//               //Cri uri para fazer fazer chamadas tipo REST
//        UriComponents uri = UriComponentsBuilder.newInstance()
//                .scheme(clientesApiConfiguration.clienteScheme)
//                .host(clientesApiConfiguration.clientesHost)
//                .path(clientesApiConfiguration.listarClientes + id )
//                .queryParam(clientesApiConfiguration.clientesParamName,clientesApiConfiguration.clientesParamValue)
//                .build();
//
//
//        //Cria entidade Cliente com os dados da API
//        ResponseEntity<Cliente> entity = template.getForEntity(uri.toUriString(), Cliente.class);
//        Cliente  cliente = new Cliente();
//        cliente.setEmail(entity.getBody().getEmail());
//        cliente.setTelefone(entity.getBody().getTelefone());
//        cliente.setPreferencia(entity.getBody().getPreferencia());
//
//        Assert.assertEquals("SMS",entity.getBody().getPreferencia());
//        Assert.assertEquals("http://localhost:8082/clientes/listar/6010602edec9b27db236975a?fields=all",uri.toUriString());
//    }
}



