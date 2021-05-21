package br.com.compasso.notificacao.notificationApi.service;

import br.com.compasso.notificacao.notificationApi.configuration.ClietesURL;
import br.com.compasso.notificacao.notificationApi.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Service
public class ConsumeAPICliente {

    Logger logger = LoggerFactory.getLogger(ConsumeAPICliente.class);

    @Autowired
    ClietesURL clietesURL;

    public Cliente consumeAPI(String id) {

        RestTemplate template = new RestTemplate();

        logger.info("Criando URI de API Clientes");

        UriComponents uri = clietesURL.criarUri(id);

        ResponseEntity<Cliente> entity = template.getForEntity(uri.toUriString(), Cliente.class);

         Cliente  cliente = new Cliente();
         cliente.setEmail(entity.getBody().getEmail());
         cliente.setTelefone(entity.getBody().getTelefone());
         cliente.setPreferencia(entity.getBody().getPreferencia());

         return cliente;
    }
}
