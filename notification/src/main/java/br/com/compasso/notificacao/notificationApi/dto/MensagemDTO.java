package br.com.compasso.notificacao.notificationApi.dto;

import br.com.compasso.notificacao.notificationApi.model.Mensagem;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MensagemDTO {

    public Long id;
    public String id_Cliente;
    public String mensagem;
    public Date data;


    public MensagemDTO(Mensagem mensagem){
        this.id = mensagem.getId();
        this.id_Cliente = mensagem.getId_Cliente();
        this.mensagem = mensagem.getMensagem();
        this.data = mensagem.getData();

    }
    public static List<MensagemDTO> converter(List<Mensagem> mensagens) {
           return mensagens.stream().map(MensagemDTO::new).collect(Collectors.toList());
    }


    public Long getId() {

        return id;
    }

    public String getId_Cliente() {

        return id_Cliente;
    }

    public String getMensagem() {
        return mensagem;
    }
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss", timezone="GMT-3")
    public Date getData() {
            return data;
    }
}
