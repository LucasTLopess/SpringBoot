package br.com.compasso.notificacao.notificationApi.dto;

import br.com.compasso.notificacao.notificationApi.model.Cliente;

public class ClienteDTO {

    public Long id;
    public String nome;
    public String email;
    public String telefone;

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

    public Long getId() {

        return id;
    }

    public String getNome() {

        return nome;
    }

    public String getEmail() {

        return email;
    }

    public String getTelefone() {

        return telefone;
    }
}
