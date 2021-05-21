package com.application.pagamento.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.application.pagamento.model.Cliente;
import com.application.pagamento.model.Pagamento;
import com.application.pagamento.model.Pedido;
import com.application.pagamento.model.Status;
import com.application.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {

	Logger logger = LoggerFactory.getLogger(PagamentoService.class);

	private RestTemplate restTemplate = new RestTemplateBuilder().build();

	@Value("${app.consume}")
	private String clienteC;
	
	@Value("${app.testeInt}")
	private int testeInt;

	@Autowired
	PagamentoRepository pagamentoRepository;

	@Autowired
	PagamentoService pagamentoService;

	public ResponseEntity<Pagamento> realizarPagamento(Pedido pedido) {

		logger.info("Acessando o metodo Realizar Pagamento");

		if (pagamentoService.verificaAtivo(pedido.getIdCliente()) == true) {

			Pagamento pagamento = pagamentoRepository.save(new Pagamento(pedido));

			logger.debug("Pagamento salvo no Repositorio de Pagamentos");

			return ResponseEntity.status(201).body(pagamento);

		} else {
			logger.debug("ResponseEntity not Found");
			return ResponseEntity.notFound().build();

		}

	}

	@SuppressWarnings("finally")
	public boolean verificaAtivo(String idCliente) {
		logger.info("Acessando método que verifica se cliente esta ativo" + testeInt);

		Cliente cliente = restTemplate.getForObject(clienteC, Cliente.class, idCliente);
		
		
			if (cliente.getStatus().equals(Status.ATIVO)) {
				logger.info("getStatus = Ativo");
				return true;
			} else {
				logger.info("getStatus = Inativo");
				return false;
			}
		

	}

	public ResponseEntity<List<Pagamento>> buscaPagamentos() {
		logger.info("ListandoTodosOsPagamentos");
		List<Pagamento> pagamento = pagamentoRepository.findAll();
		return ResponseEntity.ok(pagamento);
	}

	public ResponseEntity<Pagamento> pagamentoPorId(String id) {
		logger.info("Acessando método listar por Id");
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		if (pagamento.isPresent()) {
			logger.debug("Pagamento Listado.");
			return ResponseEntity.ok(pagamento.get());
		}
		logger.debug("Pagamento: " + id + "pagamento");
		return ResponseEntity.status(406).build();
	}

}
