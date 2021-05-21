package br.com.compasso.promocao.PromocaoAPI.DTO;

import br.com.compasso.promocao.PromocaoAPI.Models.Produtos;
import br.com.compasso.promocao.PromocaoAPI.Services.PromocaoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PedidoDTO {
	
	Logger logger = LoggerFactory.getLogger(PedidoDTO.class);  
	
    private Long idPedido;

    private int valorPedido;

    public Long getIdPedido() {
    	logger.info("Retorna id pedido");
        return idPedido;
    }

    public void setIdPedido(Long idPedido) { 
        this.idPedido = idPedido;
    }

    public int getValorPedido() {
    	logger.info("Retorna valor do pedido");
        return valorPedido;
    }

    public void setValorPedido(int valorPedido) {
        this.valorPedido = valorPedido;
    }


}
