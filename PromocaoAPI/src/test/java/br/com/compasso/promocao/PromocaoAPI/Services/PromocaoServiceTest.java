package br.com.compasso.promocao.PromocaoAPI.Services;

import br.com.compasso.promocao.PromocaoAPI.DTO.PedidoDTO;
import br.com.compasso.promocao.PromocaoAPI.Models.Categoria;
import br.com.compasso.promocao.PromocaoAPI.Models.Pedido;
import br.com.compasso.promocao.PromocaoAPI.Models.Produtos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PromocaoServiceTest {
    @Test
    public void deveCompararCategorias() {

        //Criando Produtos
        Produtos produto1 = new Produtos();
        produto1.setIdProduto(6);
        Produtos produto2 = new Produtos();
        produto2.setIdProduto(7);
        Produtos produto3 = new Produtos();
        produto3.setIdProduto(1);
        Produtos produto4 = new Produtos();
        produto4.setIdProduto(8);
        Produtos produto5 = new Produtos();
        produto5.setIdProduto(6);

        //Criando Lista de produtos
        List<Produtos> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        //Criando pedido
        Pedido pedido = new Pedido();
        pedido.setIdCliente("1");
        pedido.setProdutos(produtos);

        Categoria categoria = new Categoria();
        Long[]contCategoriaList = new Long[produtos.size()];
        Long[]CategoriaList;
        int contCategoria = 0;
        int cont = 0;

        for (Produtos produtosTeste : produtos) {
            produtosTeste.getIdProduto();

            RestTemplate template = new RestTemplate();
            UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost:8080")
                    .path("/produtos/listar/" + produtosTeste.getIdProduto())
                    .queryParam("fields","all")
                    .build();
            ResponseEntity<Produtos> entityProduto = template.getForEntity(uri.toUriString(), Produtos.class);
            produtosTeste.setPreco(entityProduto.getBody().getPreco());
            produtosTeste.setCategoria(entityProduto.getBody().getCategoria());
            categoria = produtosTeste.getCategoria();
            contCategoriaList[cont]=categoria.getId();
            cont++;

        }

        int resp =0;
        for (int i = 0; i <= contCategoriaList.length; i++) {
            for (int j = i + 1; j < contCategoriaList.length; j++) {
                if (contCategoriaList[j] == contCategoriaList[i]) {
                    resp = 1; // há uma categoria repetida
                }
            }
        }

        System.out.println(resp);
        System.out.println(pedido.getProdutos().get(0).getCategoria().getId());
        System.out.println(contCategoria);
        System.out.println(Arrays.toString(contCategoriaList));

    }
//    @Test
//    public void calcularPromocao (Pedido pedido) {
//
//
//            List<Produtos> produtos = pedido.getProdutos();
//            int valorTotal = 0;
//            Categoria categoria = new Categoria();
//            Long[] contCategoriaList = new Long[produtos.size()];
//            int contCategoria = 0;
//            int cont = 0;
//            int resp = 0;
//
//
//    			cont++;
//    		}
//    		// Verifica se há mais de um produto com a mesma categoria
//
//    			List<Produtos> produtos =  pedido.getProdutos();
//    			int valorTotal = 0;
//    			Categoria categoria = new Categoria();
//    			Long[]contCategoriaList = new Long[produtos.size()];
//    			int contCategoria = 0;
//    			int cont = 0;
//    			int resp =0;
//
//            logger.info("Acessando calcularPromocao");
//
//    			for (Produtos produtos2 : produtos) {
//    				produtos2.getIdProduto();
//
//    			   RestTemplate template = new RestTemplate();
//    			   UriComponents uri = UriComponentsBuilder.newInstance()
//    			         .scheme("http")
//    			         .host("localhost:8088")
//    			         .path("/produtos/listar/" + produtos2.getIdProduto())
//    			         .queryParam("fields","all")
//    			         .build();
//    			   ResponseEntity<Produtos> entityProduto = template.getForEntity(uri.toUriString(), Produtos.class);
//    			   produtos2.setPreco(entityProduto.getBody().getPreco());
//    			   produtos2.setCategoria(entityProduto.getBody().getCategoria());
//    			   valorTotal += entityProduto.getBody().getPreco();
//    			   categoria = produtos2.getCategoria();
//    			   contCategoriaList[cont]=categoria.getId();
//    			   cont++;
//    			}
//    		//Verifica se há mais de um produto com a mesma categoria
//
//    		for (int i = 0; i <= contCategoriaList.length; i++) {
//    			for (int j = i + 1; j < contCategoriaList.length; j++) {
//    				if (contCategoriaList[j] == contCategoriaList[i]) {
//    					resp = 1; // Se houver uma categoria repetida.
//    				}
//    			}
//    		}
//
//
//    		// Valida promoção de 20%
//    		if (pedido.getQuantidadePedidoCliente() == 1) {
//    			valorTotal -= valorTotal * 20 / 100;
//    		}
//    		// Valida promoção de 10%
//    		else {
//    			if (pedido.getProdutos().size() >= 3) {
//    				valorTotal -= valorTotal * 10 / 100;
//    			}
//    			// Valida promoção de 5%
//    			else {
//    				if (resp >= 1) {
//    					valorTotal -= valorTotal * 5 / 100;
//    				}
//    			}
//    		}
    }
    
    
