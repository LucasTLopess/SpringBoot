package com.example.projeto.cliente.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import com.example.projeto.cliente.repository.ClienteRepository;
import com.example.projeto.cliente.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.example.projeto.cliente.dto.ClienteDetalhadoDto;
import com.example.projeto.cliente.dto.ClienteDto;
import com.example.projeto.cliente.form.AtualizacaoClienteForm;
import com.example.projeto.cliente.form.ClienteForm;

@RestController
@RequestMapping("/clientes") //classe respnde requisicoes com /listar
public class ClienteController {
	
	Logger logger = LoggerFactory.getLogger(ClienteController.class); //indica que classe esta usando o logger
	
	 @Autowired
	 ClienteService clienteService;
	
	/*LISTA DOS DADOS DO CLIENTE*/
	@GetMapping("/listar")
	public List<ClienteDto> lista(){
		logger.info("Controller : Requisiçao no serviço listar"); /* LOGGER EXIBE A INFO */
		return clienteService.listar();
	}

	@GetMapping("listar/{id}")
	public ResponseEntity<ClienteDetalhadoDto> detalhar(@PathVariable String id) {
		/*DETALHAMENTO OS DADOS DE UM UNICO CLIENTE, PELO ID.*/
		logger.info("Controller : Requisiçao no serviço listar por Id"); /* LOGGER EXIBE A INFO */
		return clienteService.listarPorId(id);
	}

	/*METODO DE CADASTRAMENTO DE DADOS*/
	@PostMapping("/salvar")
	public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteForm form) {
		logger.info("Controller : Requisição no serviço salvar");; /* LOGGER EXIBE A INFO */
		return clienteService.salvar(form);
	}

	/* ATUALIZA OS DADOS DO CLIENTE, NO BD*/
	@PutMapping("atualizar/{id}")
	public ResponseEntity<ClienteDto> atualizar(@PathVariable String id,@RequestBody AtualizacaoClienteForm form){
		logger.info("Controller : Requisição no serviço de atualizar");/* LOGGER EXIBE A INFO */
		return clienteService.atualizar(id,form);

	}

	/*DELETAR DADOS DO CLIENTE PELO ID E VOLTA COM O 200*/
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<?> remover(@PathVariable String id){
		logger.info("removendo"); /* LOGGER EXIBE A INFO*/
		return clienteService.deletar(id);

	}
	
}
