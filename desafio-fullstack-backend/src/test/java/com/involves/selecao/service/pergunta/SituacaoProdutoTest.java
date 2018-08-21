package com.involves.selecao.service.pergunta;

import org.junit.Test;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;

import junit.framework.Assert;

public class SituacaoProdutoTest {
	
	@Test
	public void processarProdutoAusenteNaGondulaTest(){
		IPergunta precoProduto = new ProdutoAusente();
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setPreco_estipulado("1");
		pesquisa.setProduto("Teste Produto");
		pesquisa.setPonto_de_venda("Ponto de Venda Teste");
		
		Resposta resposta = new Resposta();
		resposta.setResposta("Produto ausente na gondola");
		
		Alerta processar = precoProduto.processar(pesquisa, resposta);
		
		Assert.assertEquals("Ruptura detectada!", processar.getDescricao());
		Assert.assertEquals("1", processar.getFlTipo().toString());
		Assert.assertEquals("Teste Produto", processar.getProduto());
		Assert.assertEquals("Ponto de Venda Teste", processar.getPontoDeVenda());
	}
	
	
}
