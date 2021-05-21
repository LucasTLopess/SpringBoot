package br.com.compasso.promocao.PromocaoAPI.Models;

import br.com.compasso.promocao.PromocaoAPI.DTO.PedidoDTO;
import br.com.compasso.promocao.PromocaoAPI.Services.PromocaoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pedido extends PedidoDTO {
	
	Logger logger = LoggerFactory.getLogger(PromocaoService.class);  
	
	//Estes são os  atributos da entidade pedido. 
	private String idCliente;
	private List<Produtos> Produtos ;
	private long quantidadePedidoCliente;

	public long getQuantidadePedidoCliente()   { 
		 logger.info("Retorna Quantidade de pedido do cliente"); 
		return quantidadePedidoCliente; 
		}

	public void setQuantidadePedidoCliente(long quantidadePedidoCliente) {
		logger.info("Quantidade de Pedido de Cliente");
		this.quantidadePedidoCliente = quantidadePedidoCliente;	
		}

	public String getIdCliente() {
		logger.info("Retorna ID do cliente "); 
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public List<Produtos> getProdutos() {
		logger.info("Retorna produtos");
		return Produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		Produtos = produtos;
	}
	
	
}
