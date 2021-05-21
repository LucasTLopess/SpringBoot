package br.com.compasso.notificacao.notificationApi.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;



@Component
public class ClietesURL {

    @Autowired
    ClientesApiConfiguration clientesApiConfiguration;

    Logger logger = LoggerFactory.getLogger(ClietesURL.class);

    public UriComponents criarUri(String id){
        logger.info("Criando URL");

        RestTemplate template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme(clientesApiConfiguration.clienteScheme)
                .host(clientesApiConfiguration.clientesHost)
                .path(clientesApiConfiguration.listarClientes + id )
                .queryParam(clientesApiConfiguration.clientesParamName,clientesApiConfiguration.clientesParamValue)
                .build();

        logger.debug(uri.toUriString());

        return uri;
    }
}
