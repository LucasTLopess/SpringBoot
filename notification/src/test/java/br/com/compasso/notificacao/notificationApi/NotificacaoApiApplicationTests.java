package br.com.compasso.notificacao.notificationApi;

import br.com.compasso.notificacao.notificationApi.model.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotificacaoApiApplicationTests {

//	@Test
//	public void consumeAPI() {
//		RestTemplate template = new RestTemplate();
//
//		UriComponents uri = UriComponentsBuilder.newInstance()
//				.scheme("http")
//				.host("localhost:8082")
//				.path("/listar/1")
//				.queryParam("fields","all")
//				.build();
//
//		ResponseEntity<Cliente> entity = template.getForEntity(uri.toUriString(), Cliente.class);
//
//		System.out.println(entity.getBody().getNome());
//		entity.getBody().setPreferencia("email");
//		System.out.println(entity.getBody().getPreferencia());
//
//	}
//	@Test
//	public void consumeAPIPost() {
//		RestTemplate template = new RestTemplate();
//
//		UriComponents uri = UriComponentsBuilder.newInstance()
//				.scheme("http")
//				.host("localhost:8080")
//				.path("/listar/")
//				.queryParam("fields","all")
//				.build();
//
//		ResponseEntity<Cliente> entity = template.getForEntity(uri.toUriString(), Cliente.class);
//
//		System.out.println(entity.getBody().getNome());
//	}

}
