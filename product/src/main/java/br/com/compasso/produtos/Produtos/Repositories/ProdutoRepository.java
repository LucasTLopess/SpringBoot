package br.com.compasso.produtos.Produtos.Repositories;

import br.com.compasso.produtos.Produtos.Models.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository <Produto, Long > {

    public List<Produto> findByid(long parseLong);

    public List<Produto> findBynome(String nome);

    public List<Produto> findBycategoria(String categoria);

    public List<Produto> findBydescricao(String descricao);

    public List<Produto> findBypreco(int parseInt);

    public List<Produto> findBysku(String sku);

    public String deleteByid(long parseLong);

    


}
