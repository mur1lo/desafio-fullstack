package com.involves.selecao.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.service.BuscaAlertasService;
import com.involves.selecao.service.ProcessadorAlertasService;

@RestController
@RequestMapping("/alertas")
public class AlertaRest {

	@Autowired
	private BuscaAlertasService buscaAlertasService;
	
	@Autowired
	private ProcessadorAlertasService processador;
	
	@GetMapping
    public List<Alerta> alertas() {
		return buscaAlertasService.buscarTodos();
    }
	
	@GetMapping("/processar")
    public ResponseEntity processar() {
		try {
			processador.processa();
			return ResponseEntity.ok().build();
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
    }
}
