package com.example.projeto.cliente.service;

import com.example.projeto.cliente.dto.ClienteDetalhadoDto;
import com.example.projeto.cliente.dto.ClienteDto;
import com.example.projeto.cliente.form.AtualizacaoClienteForm;
import com.example.projeto.cliente.form.ClienteForm;
import com.example.projeto.cliente.modelo.Cliente;
import com.example.projeto.cliente.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteDto> listar(){
        logger.info("Acessando método listar");
        List<Cliente> clientes = clienteRepository.findAll();
        return ClienteDto.converter(clientes);
    }

    public ResponseEntity<ClienteDetalhadoDto> listarPorId(String id){
        logger.info("Acessando método listar por Id");
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        if(cliente.isPresent()) {
            logger.debug("Cliente listado.");
            return ResponseEntity.ok(new ClienteDetalhadoDto(cliente.get()));
        }
        logger.debug("Cliente: " + id + "não existe");
        return  ResponseEntity.status(406).build();
    }

    public ResponseEntity<ClienteDto> salvar(ClienteForm form){
        logger.info("Acessando método Salvar");
        Cliente cliente = form.converter();
        clienteRepository.save(cliente);
        return ResponseEntity.status(201).body(new ClienteDto(cliente));
    }

    public ResponseEntity<ClienteDto> atualizar(String id, AtualizacaoClienteForm form){
        logger.info("Acessando método Atualizar");
        Optional<Cliente> optional =  clienteRepository.findById(id);
        if(optional.isPresent()) {
            logger.debug("Atualizando o cliente : " + id);
            Cliente cliente = form.atualizar(id,clienteRepository);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(new ClienteDto(cliente));
        }
        logger.debug("O cliente id: "+ id + "não foi encontrado");
        return  ResponseEntity.status(406).build();

    }

    public ResponseEntity<?> deletar(String id){
        logger.info("Acessando método deletar");
        Optional<Cliente> optional =  clienteRepository.findById(id);
        if(optional.isPresent()) {
            logger.info("Cliente : "+ id +"deletado com sucesso");
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();

        }
        logger.info("Cliente id : " + id + "não foi encontrado");
        return ResponseEntity.status(406).build();
    }


}
