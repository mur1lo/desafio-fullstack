package com.involves.selecao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.repository.AlertaRepository;

@Service
public class BuscaAlertasService {
	
	@Autowired
	private AlertaRepository alertaRepository;
	
	public List<Alerta> buscarTodos() {
		return alertaRepository.findAll();
	}

}
