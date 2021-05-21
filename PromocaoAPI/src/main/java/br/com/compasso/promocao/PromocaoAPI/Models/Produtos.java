package br.com.compasso.promocao.PromocaoAPI.Models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


	
	public class Produtos {
		Logger logger = LoggerFactory.getLogger(Produtos.class);  
		private long idProduto;
		private  int  preco;
		private Categoria categoria;
	
	
		public Categoria getCategoria() { 
			logger.info("Retorna Categoria");
			return categoria;	
			}
	
		public void setCategoria(Categoria categoria) {	
			
			this.categoria = categoria;	
			}
	
		public long getIdProduto() {
			logger.info("Retorna id do produto ");
			return idProduto;
		}
	
		public void setIdProduto(long idProduto) {
			this.idProduto = idProduto;
		}
	
		public int getPreco() {
			logger.info("Retorna preço");
			return preco;
		}
	
		public void setPreco(int preco) {
			this.preco = preco;
		}
			
		
	}
