package br.com.compasso.notificacao.notificationApi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "Mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    @Column(name = "id_Cliente")
    public String id_Cliente;
    @Column(name = "mensagem")
    public String mensagem;
    @Column(name = "data")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getId_Cliente() { return id_Cliente; }

    public void setId_Cliente(String id_Cliente) {  this.id_Cliente = id_Cliente;  }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", timezone="GMT-3")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
