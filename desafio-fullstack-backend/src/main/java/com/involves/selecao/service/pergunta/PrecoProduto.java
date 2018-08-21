package com.involves.selecao.service.pergunta;


import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;
import com.involves.selecao.domain.builder.AlertaBuilder;
import com.involves.selecao.domain.enumeration.TipoAlerta;
import com.involves.selecao.utils.Constants;

public class PrecoProduto implements IPergunta{

    @Override
    public Alerta processar(Pesquisa pesquisa, Resposta resposta) {
        int precoColetado = Integer.parseInt(resposta.getResposta());
        int precoEstipulado = Integer.parseInt(pesquisa.getPreco_estipulado());
        AlertaBuilder alertaBuilder = new AlertaBuilder();
        if (precoColetado > precoEstipulado) {
            int margem = precoColetado - precoEstipulado;
            alertaBuilder.margem(margem).descricao(Constants.PRECO_SUPERIOR).flTipo(TipoAlerta.PRECO_SUPERIOR.getValor());
        } else if (precoColetado < precoEstipulado) {
            int margem = precoEstipulado - precoColetado;
            alertaBuilder.margem(margem).descricao(Constants.PRECO_INFERIOR).flTipo(TipoAlerta.PRECO_INFERIOR.getValor());
        }
        alertaBuilder.produto(pesquisa.getProduto()).pontoVenda(pesquisa.getPonto_de_venda()).notificante(pesquisa.getNotificante()).rotulo(pesquisa.getRotulo()).id(pesquisa.getId());
        return alertaBuilder.criar();
    }
}
