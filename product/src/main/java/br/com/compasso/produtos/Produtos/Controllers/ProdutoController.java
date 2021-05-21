package br.com.compasso.produtos.Produtos.Controllers;


import br.com.compasso.produtos.Produtos.Models.Produto;
import br.com.compasso.produtos.Produtos.Services.ProdutoService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    Logger logger = LoggerFactory.getLogger(CategoriaController.class);
    
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/salvar")
    public Produto salvarProduto(@RequestBody Produto produto) {
        logger.info("requisição em /produtos/salvar");
        return produtoService.salvar(produto);
    }

    @GetMapping("/listar")
    public List<Produto> listarProduto(Produto produto) {
        logger.info("requisição em /produtos/listar");
        return produtoService.listar(produto);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Long id) {
        logger.info("requisição em /produtos/listar/{id}");
        return produtoService.listarPorId(id);
    }
    @PostMapping("/atualizar")
    public Produto atualizar(@RequestBody Produto produto) {
        logger.info("requisição em /produtos/salvar");
        return produtoService.atualizar(produto);
    }

    @GetMapping("/deletar/todos")
    public String deletarTodas(){
        logger.info("requisição em /produtos/deletar/todos");
        return produtoService.deletarTodas();
    }

    @DeleteMapping ("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id){
        logger.info("requisição em /produtos/deletar/id");
        return produtoService.deletarPorId(id);
    }


}
