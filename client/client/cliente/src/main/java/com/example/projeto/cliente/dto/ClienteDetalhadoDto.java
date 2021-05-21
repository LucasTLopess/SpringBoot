package com.example.projeto.cliente.dto;

import com.example.projeto.cliente.modelo.Cliente;
import com.example.projeto.cliente.modelo.Preferencia;
import com.example.projeto.cliente.modelo.Status;

public class ClienteDetalhadoDto {

	private String nome;
	private String email;
	private String Logradouro;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String telefone;
	private String cnpj;
	private Status status;
	private Preferencia preferencia;

	public ClienteDetalhadoDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
		this.cnpj = cliente.getCnpj();
		this.email = cliente.getEmail();
		this.Logradouro = cliente.getLogradouro();
		this.cep = cliente.getCep();
		this.uf = cliente.getUf();
		this.bairro = cliente.getBairro();
		this.cidade = cliente.getCidade();
		this.status = cliente.getStatus();
		this.preferencia = cliente.getPreferencia();
	}



	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Status getStatus() {
		return status;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}
}
