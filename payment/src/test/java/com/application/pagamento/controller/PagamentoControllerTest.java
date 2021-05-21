package com.application.pagamento.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.application.pagamento.model.Pagamento;
import com.application.pagamento.services.PagamentoService;

import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest
public class PagamentoControllerTest {

	Logger logger = LoggerFactory.getLogger(PagamentoController.class);

	@Autowired
	private PagamentoController pagamentoController;

	@MockBean
	private PagamentoService pagamentoService;
	
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.pagamentoController);
	}

	@Test
	public void deveRetornarSucesso_QuandoBuscarPagamentos() {

		org.mockito.Mockito.when(this.pagamentoService.pagamentoPorId("22"))
				.thenReturn(ResponseEntity.ok(new Pagamento()));

		given().accept(ContentType.JSON).when().get("/pagamento/buscar/{id}", "22").then()
				.statusCode(HttpStatus.OK.value());

	}

	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarPagamento() {

		org.mockito.Mockito.when(this.pagamentoService.pagamentoPorId("3242"))
				.thenReturn(ResponseEntity.notFound().build());

		given().accept(ContentType.JSON).when().get("/pagamento/buscar/{id}", "3242").then()
				.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveDevolver200CasoPagamentoSejaRealizado() throws Exception {
		URI uri = new URI("/pagamento/pagar");
		String json = "{\"valorPedido\":\" 55 \", \" idCliente \": \"601082c65643f00ad8fc133e\"}\"";
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
	
	}
	




}
