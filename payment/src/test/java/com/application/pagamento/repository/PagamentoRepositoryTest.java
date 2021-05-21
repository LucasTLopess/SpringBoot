package com.application.pagamento.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.application.pagamento.model.Pagamento;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PagamentoRepositoryTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@MockBean
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveRetornarSucesso_SeBuscouNoRepositorioDePagamentos() throws Exception {
		List<Pagamento> pagamentos = new ArrayList<>();
		Pagamento pagamento1 = new Pagamento("1233545", 200);
		Pagamento pagamento2 = new Pagamento("13325", 300);
		pagamentos.add(pagamento1);
		pagamentos.add(pagamento2);

		org.mockito.Mockito.when(pagamentoRepository
				.findAll())
		.thenReturn(pagamentos);
		
		ResponseEntity<String> response = restTemplate
				.getForEntity("/pagamento/buscar", String.class);
		
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		
		

	}
}
