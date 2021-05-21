package br.com.compasso.notificacao.notificationApi.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ClientesApiConfiguration {

    @Value("${clientes.scheme}")
    public String clienteScheme;

    @Value("${clientes.host}")
    public String clientesHost;

    @Value("${clientes.path-listar}")
    public String listarClientes;

    @Value("${clientes.queryParamName}")
    public String clientesParamName;

    @Value("${clientes.queryParamValue}")
    public String clientesParamValue;

}