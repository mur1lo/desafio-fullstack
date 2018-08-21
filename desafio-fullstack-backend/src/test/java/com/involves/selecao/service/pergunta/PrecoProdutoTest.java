package com.involves.selecao.service.pergunta;

import org.junit.Test;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.Pesquisa;
import com.involves.selecao.domain.Resposta;

import junit.framework.Assert;

public class PrecoProdutoTest {
	
	@Test
	public void processarPrecoAcimaDoEstipuladoTest(){
		IPergunta precoProduto = new PrecoProduto();
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setPreco_estipulado("1");
		pesquisa.setProduto("Teste Produto");
		pesquisa.setPonto_de_venda("Ponto de Venda Teste");
		
		Resposta resposta = new Resposta();
		resposta.setResposta("2");
		
		Alerta processar = precoProduto.processar(pesquisa, resposta);
		
		Assert.assertEquals("Preço acima do estipulado!", processar.getDescricao());
		Assert.assertEquals("2", processar.getFlTipo().toString());
		Assert.assertEquals("Teste Produto", processar.getProduto());
		Assert.assertEquals("Ponto de Venda Teste", processar.getPontoDeVenda());
	}
	
	@Test
	public void processarPrecoAbaixoDoEstipuladoTest(){
		IPergunta precoProduto = new PrecoProduto();
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setPreco_estipulado("2");
		pesquisa.setProduto("Teste Produto");
		pesquisa.setPonto_de_venda("Ponto de Venda Teste");
		
		Resposta resposta = new Resposta();
		resposta.setResposta("1");
		
		Alerta processar = precoProduto.processar(pesquisa, resposta);
		
		Assert.assertEquals("Preço abaixo do estipulado!", processar.getDescricao());
		Assert.assertEquals("3", processar.getFlTipo().toString());
		Assert.assertEquals("Teste Produto", processar.getProduto());
		Assert.assertEquals("Ponto de Venda Teste", processar.getPontoDeVenda());
	}
	
}
