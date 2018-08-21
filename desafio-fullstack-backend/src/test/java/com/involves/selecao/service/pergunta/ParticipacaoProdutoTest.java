package com.involves.selecao.service.pergunta;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;
import com.involves.selecao.domain.enumeration.TipoAlerta;
import junit.framework.Assert;
import org.junit.Test;

public class ParticipacaoProdutoTest {


    @Test
    public void processarParticipacaoProdutoSuperiorTeste() {
        IPergunta partipacaoPergunta = new ParticipacaoProduto();
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setCategoria("Shampoo");
        pesquisa.setParticipacao_estipulada("30");
        pesquisa.setPonto_de_venda("Padaria do Alemão");

        Resposta resposta = new Resposta();
        resposta.setResposta("10");


        Alerta processar = partipacaoPergunta.processar(pesquisa, resposta);

        Assert.assertEquals("Participação superior ao estipulado!", processar.getDescricao());
        Assert.assertEquals("4", processar.getFlTipo().toString());
        Assert.assertEquals("Shampoo", processar.getProduto());
        Assert.assertEquals("Padaria do Alemão", processar.getPontoDeVenda());

    }

    @Test
    public void processarParticipacaoProdutoInferiorTeste() {
        IPergunta partipacaoPergunta = new ParticipacaoProduto();
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.setCategoria("Sabonetes");
        pesquisa.setParticipacao_estipulada("25");
        pesquisa.setPonto_de_venda("Padaria do Alemão");

        Resposta resposta = new Resposta();
        resposta.setResposta("27");


        Alerta processar = partipacaoPergunta.processar(pesquisa, resposta);

        Assert.assertEquals("Participação inferior ao estipulado!", processar.getDescricao());
        Assert.assertEquals("5", processar.getFlTipo().toString());
        Assert.assertEquals("Sabonetes", processar.getProduto());
        Assert.assertEquals("Padaria do Alemão", processar.getPontoDeVenda());

    }


}
