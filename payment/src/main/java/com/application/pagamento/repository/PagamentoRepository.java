package com.application.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.pagamento.model.Pagamento;

public interface PagamentoRepository extends MongoRepository<Pagamento, String>{

}
