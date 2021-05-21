package br.com.compasso.produtos.Produtos.Services;

import br.com.compasso.produtos.Produtos.Models.Produto;
import br.com.compasso.produtos.Produtos.Repositories.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;

@Component
public class ProdutoService {

    Logger logger = LoggerFactory.getLogger(ProdutoService.class);

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        logger.info("Acessando metodo salvar");
        if (produtoRepository.existsById(produto.getId()) == true) {
            logger.info("O produto" + produto.getId() + "já existia ");
            return null;
        } else {
            logger.info("Insert do novo produto");
            return produtoRepository.save(produto);
        }
        
    }

    public List<Produto> listar(Produto produto) {
        logger.info("Acessando metodo listar");
            logger.info("Buscando todos os produtos no banco de dados ");
            return produtoRepository.findAll();
         }

    public ResponseEntity<Produto> listarPorId(Long id) {
        logger.info("Acessando metodo listar");
        if (produtoRepository.existsById(id) == true) {
            logger.info("Buscando produto id:"+ id + " no banco de dados ");
            return  ResponseEntity.ok().body(produtoRepository.findById(id).get());
        } else {
            logger.warn("Produto id:"+ id + " não existe no banco de dados ");
            return null;
        }
    }

    public Produto atualizar(Produto produto) {
        if (produtoRepository.existsById(produto.getId()) == true) {
            logger.info("Atualizar produto de id: " + produto.getId());
            return produtoRepository.save(produto);
        } else {
            logger.info("O produto ja existe na base de dados");
            return null;
        }
    }

    public String deletarTodas() {
        logger.info("Acessando metodo deletarTodas");
        produtoRepository.deleteAll();
        logger.warn("todos os produtos da base de dados foram deletados");
        return "todos os produtos foram deletados";
    }

    @Transactional
    public String deletarPorId(Long id) {
        if (produtoRepository.existsById(id) == true) {
            produtoRepository.deleteByid(id);
        } else {
            logger.info("o id: " + id + " não foi encontrado ");
            return "O id:" + id + " não existe em nossa base de dados";
        }
        logger.info("deletado o id: " + id);
        return "Produto de id:" + id + " foi deletado  com sucesso atraves do DeletarPorId";
    }


}
