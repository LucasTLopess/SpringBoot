package br.com.compasso.promocao.PromocaoAPI.Controllers;

import br.com.compasso.promocao.PromocaoAPI.DTO.PedidoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.promocao.PromocaoAPI.Models.Pedido;
import br.com.compasso.promocao.PromocaoAPI.Services.PromocaoService;


@RestController
@RequestMapping("/promocao")
public class PromocaoController {


	Logger logger = LoggerFactory.getLogger(PromocaoController.class); 
	//Faz requisição do promoção service, para o metodo calcular promoção.
	//Toda vez que for feito uma requisição Post, ele vai chamar o metodo promoção. Ometodo  DTO  promocao, chama o metodo de calcular a promoção.
	@PostMapping
	public int Promocao(@RequestBody Pedido pedido ){
		logger.info("requisicao em /promocao");

		return PromocaoService.calcularPromocao(pedido);
		
	}
	
}
