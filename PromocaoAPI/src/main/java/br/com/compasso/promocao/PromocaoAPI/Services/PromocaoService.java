package br.com.compasso.promocao.PromocaoAPI.Services;

import br.com.compasso.promocao.PromocaoAPI.Models.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.compasso.promocao.PromocaoAPI.Models.Pedido;
import br.com.compasso.promocao.PromocaoAPI.Models.Produtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component
public class PromocaoService {

    static Logger logger = LoggerFactory.getLogger(PromocaoService.class);

    // Ele vai receber um pedido pelo controller promoção,
    // e vai retornar um pedido contendo o valor total.//
    // Este metodo ele retorna um pedido.
    public static int calcularPromocao(Pedido pedido) {

        List<Produtos> produtos = pedido.getProdutos();
        int valorTotal = 0;
        Categoria categoria = new Categoria();
        Long[] contCategoriaList = new Long[produtos.size()];
        int contCategoria = 0;
        int cont = 0;
        int resp = 0;

        logger.info("Acessando calcularPromocao");

        for (Produtos produtos2 : produtos) {
            produtos2.getIdProduto();

            RestTemplate template = new RestTemplate();
            UriComponents uri = UriComponentsBuilder.newInstance()
                    .scheme("http")
                    .host("localhost:8088")
                    .path("/produtos/listar/" + produtos2.getIdProduto())
                    .queryParam("fields", "all")
                    .build();
            ResponseEntity<Produtos> entityProduto = template.getForEntity(uri.toUriString(), Produtos.class);
            produtos2.setPreco(entityProduto.getBody().getPreco());
            produtos2.setCategoria(entityProduto.getBody().getCategoria());
            valorTotal += entityProduto.getBody().getPreco();
            categoria = produtos2.getCategoria();
            contCategoriaList[cont] = categoria.getId();
            cont++;
        }
        //Verifica se há mais de um produto com a mesma categoria
        for (int i = 0; i <= contCategoriaList.length; i++) {
            for (int j = i + 1; j < contCategoriaList.length; j++) {
                if (contCategoriaList[j] == contCategoriaList[i]) {
                    resp = 1; // Se houver uma categoria repetida.
                }
            }
        }

        // Valida promoção de 20%
        if (pedido.getQuantidadePedidoCliente() == 1) {
            valorTotal -= valorTotal * 20 / 100;
        } // Valida promoção de 10%
        else {
            if (pedido.getProdutos().size() >= 3) {
                valorTotal -= valorTotal * 10 / 100;
            } // Valida promoção de 5%
            else {
                if (resp >= 1) {
                    valorTotal -= valorTotal * 5 / 100;
                }
            }
        }

        pedido.setValorPedido(valorTotal);
        logger.warn("O valor total do pedido é" + valorTotal);
        return pedido.getValorPedido();
    }

}
