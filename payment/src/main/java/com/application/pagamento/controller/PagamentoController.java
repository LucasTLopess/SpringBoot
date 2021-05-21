package com.application.pagamento.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.pagamento.model.Pagamento;
import com.application.pagamento.model.Pedido;
import com.application.pagamento.services.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	Logger logger = LoggerFactory.getLogger(PagamentoController.class);

	@Autowired
	PagamentoService pagamentoService;

	@PostMapping("/pagar")
	public ResponseEntity<Pagamento> pagamento(@RequestBody Pedido pedido) {
		logger.info("Recebendo Json Pedido| idCliente:" + pedido.getIdCliente());
		return pagamentoService.realizarPagamento(pedido);
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Pagamento>> buscaPagamentos() {
		logger.info("Buscando todos os Pagamentos");
		return pagamentoService.buscaPagamentos();
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Pagamento> buscaPagamentoId(@PathVariable String id) {
		logger.info(id + "Buscando Por Id");
		return pagamentoService.pagamentoPorId(id);
	}

}
