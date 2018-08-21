package com.involves.selecao.service.pergunta;


import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;
import com.involves.selecao.domain.enumeration.TipoAlerta;
import com.involves.selecao.utils.Constants;

public class ProdutoAusente implements IPergunta{

    @Override
    public Alerta processar(Pesquisa pesquisa, Resposta resposta) {
        if (resposta.getResposta().equals(Constants.PRODUTO_AUSENTE_GONDOLA)) {
            Alerta alerta = new Alerta();
            alerta.setPontoDeVenda(pesquisa.getPonto_de_venda());
            alerta.setDescricao(Constants.RUPTURA_DETECTADA);
            alerta.setProduto(pesquisa.getProduto());
            alerta.setFlTipo(TipoAlerta.RUPTURA.getValor());
            alerta.setNotificante(pesquisa.getNotificante());
            alerta.setRotulo(pesquisa.getRotulo());
            alerta.setId(pesquisa.getId());
            return alerta;
        }
        return null;
    }
}
