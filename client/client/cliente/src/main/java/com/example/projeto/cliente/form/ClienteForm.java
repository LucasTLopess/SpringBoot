package com.example.projeto.cliente.form;

import com.example.projeto.cliente.modelo.Cliente;
import com.example.projeto.cliente.modelo.Preferencia;
import com.example.projeto.cliente.modelo.Status;

public class ClienteForm {

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public Cliente converter() {
		// TODO Auto-generated method stub
		return new Cliente(nome, email, logradouro, cep, bairro, cidade, uf,
				telefone, cnpj, status, preferencia);
	}
}
