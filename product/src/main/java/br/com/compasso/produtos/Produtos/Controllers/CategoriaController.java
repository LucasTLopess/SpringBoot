package br.com.compasso.produtos.Produtos.Controllers;

import br.com.compasso.produtos.Produtos.Models.Categoria;
import br.com.compasso.produtos.Produtos.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/listar")
    public List<Categoria> listar() {
        logger.info("requisição em /categorias/listar");
        return categoriaService.listar();
    }

    @PostMapping("/salvar")
    public Categoria salvar(@RequestBody Categoria categoria) {
        logger.info("requisição em /categorias/salvar");
        return categoriaService.salvar(categoria);
    }

    
    @GetMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id){
        logger.info("requisição em categorias/deletar/id");
        return categoriaService.deletarPorId(id);
    }

}
