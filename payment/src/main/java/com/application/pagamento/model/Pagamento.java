package com.application.pagamento.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Pagamento {

	@Id
	public String idPagamento;
	private LocalDateTime dataCriacao;
	private int valorPagamento;

	public Pagamento() {

	}
	
	

	public Pagamento(String idPagamento,  int valorPagamento) {
		this.idPagamento = idPagamento;
		
		this.valorPagamento = valorPagamento;
	}

	public Pagamento(Pedido pedido) {
		this.valorPagamento = pedido.getValorPedido();
		this.dataCriacao = LocalDateTime.now(ZoneId.systemDefault());
	}

	public int getValorPagamento() {
		return valorPagamento;
	}

	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

}
