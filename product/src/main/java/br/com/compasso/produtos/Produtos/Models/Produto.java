package br.com.compasso.produtos.Produtos.Models;

import javax.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {
    
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;


   @Column(name = "nome")
   private String nome;

   @Column(name = "descricao")
   private String descricao;

   @ManyToOne
   @JoinColumn(name = "categorias_id")
   private Categoria categoria;

   @Column(name = "preco")
   private int preco;

   @Column(name = "sku")
   private String sku;

   public Produto(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome;  }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
    
}
