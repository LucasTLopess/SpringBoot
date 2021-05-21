package com.example.projeto.cliente.form;

import com.example.projeto.cliente.modelo.Cliente;
import com.example.projeto.cliente.modelo.Preferencia;
import com.example.projeto.cliente.modelo.Status;
import com.example.projeto.cliente.repository.ClienteRepository;

public class AtualizacaoClienteForm {


	private String id;
	private String nome;
	private String email;
	private String logradouro;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String telefone;
	private String cnpj;
	private Status status;
	private Preferencia preferencia;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	/* SUBESCREVE O TOPICO DO CLIENTE, ATUALIZADO QUE VEM DO JSON*/
	public Cliente atualizar(String id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository
				.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não existe"));
		cliente.setNome(this.nome);
		cliente.setEmail(this.email);
		cliente.setTelefone(this.telefone);
		cliente.setCep(this.cep);
		cliente.setBairro(this.bairro);
		cliente.setCidade(this.cidade);
		cliente.setUf(this.uf);
		cliente.setCnpj(this.cnpj);
		cliente.setLogradouro(this.logradouro);
		cliente.setStatus(this.status);
		cliente.setPreferencia(this.preferencia);

		return cliente;
	}

}
