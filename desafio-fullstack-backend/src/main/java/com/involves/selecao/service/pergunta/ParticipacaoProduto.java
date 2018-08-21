package com.involves.selecao.service.pergunta;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;
import com.involves.selecao.domain.builder.AlertaBuilder;
import com.involves.selecao.domain.enumeration.TipoAlerta;
import com.involves.selecao.utils.Constants;

public class ParticipacaoProduto implements IPergunta {
    @Override
    public Alerta processar(Pesquisa pesquisa, Resposta resposta) {
        int precoParticipacaoEstipulada = Integer.parseInt(pesquisa.getParticipacao_estipulada());
        int precoParticipacaoEstipuladaResposta = Integer.parseInt(resposta.getResposta());
        AlertaBuilder alertaBuilder = new AlertaBuilder();

        if (precoParticipacaoEstipulada > precoParticipacaoEstipuladaResposta) {
            int margem = precoParticipacaoEstipulada - precoParticipacaoEstipuladaResposta;
            alertaBuilder.margem(margem).descricao(Constants.PARTICIPACAO_SUPERIOR).flTipo(TipoAlerta.PARTICIPACAO_SUPERIOR.getValor());
        } else if (precoParticipacaoEstipulada < precoParticipacaoEstipuladaResposta) {
            int margem = precoParticipacaoEstipuladaResposta - precoParticipacaoEstipulada;
            alertaBuilder.margem(margem).descricao(Constants.PARTICIPACAO_INFERIOR).flTipo(TipoAlerta.PARTICIPACAO_INFERIOR.getValor());
        }
        alertaBuilder.produto(pesquisa.getCategoria()).pontoVenda(pesquisa.getPonto_de_venda()).notificante(pesquisa.getNotificante()).rotulo(pesquisa.getRotulo()).id(pesquisa.getId());
        return alertaBuilder.criar();

    }
}
