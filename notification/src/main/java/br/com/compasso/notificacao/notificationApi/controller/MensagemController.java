package br.com.compasso.notificacao.notificationApi.controller;


import br.com.compasso.notificacao.notificationApi.dto.MensagemDTO;
import br.com.compasso.notificacao.notificationApi.model.Mensagem;
import br.com.compasso.notificacao.notificationApi.service.MensagemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {


    @Autowired
    MensagemService mensagemService;

    Logger logger = LoggerFactory.getLogger(MensagemController.class);

    @GetMapping("/listar")
    public List<MensagemDTO> listarMensagens(){
        logger.info("Chamando servico para listar todas as mensagens.");
        return MensagemDTO.converter(mensagemService.listarTodas());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Mensagem> listarMensagensPorId(@PathVariable Long id){
        logger.info("Chamando serviço para listar mensagem: "+ id);
        return mensagemService.listarPorId(id);
    }

    @PostMapping("/enviar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mensagem enviarMensagem(@RequestBody Mensagem mensagem){
        logger.info("Chamando serviço de envio de mensagem.");
        return mensagemService.enviarMensagem(mensagem);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarPorId(@PathVariable Long id){
        logger.info("Chamando serviço para deletar mensagem: "+ id);
        return mensagemService.deletarPorId(id);
    }




}
