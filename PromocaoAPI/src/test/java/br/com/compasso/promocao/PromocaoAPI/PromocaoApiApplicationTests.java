package br.com.compasso.promocao.PromocaoAPI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.compasso.promocao.PromocaoAPI.Models.Produtos;

@SpringBootTest
class PromocaoApiApplicationTests {
//	@Test
//	public void consumeAPI() {
//	   RestTemplate template = new RestTemplate();
//	   UriComponents uri = UriComponentsBuilder.newInstance()
//	         .scheme("http")
//	         .host("localhost:8080")
//	         .path("/produtos/listar/1")
//	         .queryParam("fields","all")
//	         .build();
//	   ResponseEntity<Produtos> entity = template.getForEntity(uri.toUriString(), Produtos.class);
//	   System.out.println(entity.getBody().getPreco());
//	}

}
