package br.com.compasso.notificacao.notificationApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoMensagemDto {

    private String idCliente;
    private String mensagem;
}
