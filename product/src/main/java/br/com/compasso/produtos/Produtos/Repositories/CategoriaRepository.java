package br.com.compasso.produtos.Produtos.Repositories;

import br.com.compasso.produtos.Produtos.Models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
