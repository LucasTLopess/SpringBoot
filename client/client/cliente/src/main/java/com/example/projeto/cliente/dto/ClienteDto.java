package com.example.projeto.cliente.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projeto.cliente.modelo.Cliente;

public class ClienteDto {

	private String id;
	private String nome;

	
	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();

	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}
