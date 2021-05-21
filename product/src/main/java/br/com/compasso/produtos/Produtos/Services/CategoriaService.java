package br.com.compasso.produtos.Produtos.Services;


import br.com.compasso.produtos.Produtos.Models.Categoria;
import br.com.compasso.produtos.Produtos.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.transaction.Transactional;

@Service
public class CategoriaService {
    
    Logger logger = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> listar(){
        logger.info("Acessando metodo listar");
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria){
        logger.info("Acessando metodo salvar");
        if (categoriaRepository.existsById(categoria.getId()) == true) {
            logger.info("update do id: "+categoria.getId());
        }else{
            logger.info("Insert da nova categoria");
        }
        return categoriaRepository.save(categoria);}

    @Transactional
    public String deletarPorId(Long id) {
        logger.info("Acessando metodo deletaPorId");
        if (categoriaRepository.existsById(id) == true) {
            categoriaRepository.deleteById(id);
        } else {
            logger.info("o id: "+id+" não foi encontrado ");
            return "O id:" + id + " não existe em nossa base de dados";
        }
         logger.info("deletado o id: "+id);
        return "A categoria de ID:" + id + " foi deletada com sucesso";
    }

}
