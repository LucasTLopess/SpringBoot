package com.application.pagamento.model;




public class Pedido {
	
	

	
	public Pedido(Long idPedido, int valorPedido, String idCliente) {
		
		this.idPedido = idPedido;
		this.valorPedido = valorPedido;
		this.idCliente = idCliente;
	}

	private Long idPedido;

	public int valorPedido;

	public String idCliente;

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Pedido() {

	}

	public int getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(int valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

}
