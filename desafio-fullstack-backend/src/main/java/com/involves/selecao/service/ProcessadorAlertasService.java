package com.involves.selecao.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.involves.selecao.app.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;
import com.involves.selecao.repository.AlertaRepository;
import com.involves.selecao.service.pergunta.IPergunta;
import com.involves.selecao.service.pergunta.OpcaoPergunta;
import com.involves.selecao.utils.HttpClientHelper;

@Service
public class ProcessadorAlertasService {

    @Autowired
    private AlertaRepository alertaRepository;

    @Autowired
    private HttpClientHelper clientHelper;

    @Autowired
    private ApplicationProperties applicationProperties;

    public void processa() throws IOException {

        String resource = applicationProperties.getUrlProcessarAlertas();
        ResponseEntity<String> retorno = clientHelper.doGet(resource, null);

        Pesquisa[] ps = new Gson().fromJson(retorno.getBody(), Pesquisa[].class);
        List<Pesquisa> listaPesquisa = (List) Arrays.asList(ps);


        listaPesquisa.forEach(pesquisa -> {
            pesquisa.getRespostas().forEach(resposta -> {
                OpcaoPergunta opcaoPergunta = OpcaoPergunta.fromString(resposta.getPergunta());
                if (opcaoPergunta == null) {
                    System.out.println("Alerta ainda não implementado!");
                } else {
                    IPergunta pergunta = opcaoPergunta.obterPergunta();
                    Alerta alertaNew = pergunta.processar(pesquisa, resposta);
                    if (alertaNew != null) {
                        alertaRepository.save(alertaNew);
                    }
                }
            });

        });
    }
}

