package br.com.compasso.notificacao.notificationApi;

import br.com.compasso.notificacao.notificationApi.configuration.ConfigRabbitMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class NotificacaoApiApplication {

	@Autowired
	ConfigRabbitMQ configRabbitMQ;

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoApiApplication.class, args);

	}

}
