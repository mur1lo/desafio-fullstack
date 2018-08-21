package com.involves.selecao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.involves.selecao.domain.Alerta;

public interface AlertaRepository extends MongoRepository<Alerta, String> {
	
}
