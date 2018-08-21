package com.involves.selecao.service.pergunta;


import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;

public interface IPergunta {

    public Alerta processar(Pesquisa pesquisa, Resposta resposta);
}
