package com.example.projeto.cliente.repository;



import com.example.projeto.cliente.modelo.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//interface para acesso ao bd 
@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
	
}
