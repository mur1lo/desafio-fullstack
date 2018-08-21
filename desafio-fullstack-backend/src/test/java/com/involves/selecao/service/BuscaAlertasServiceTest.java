package com.involves.selecao.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.involves.selecao.domain.Alerta;
import com.involves.selecao.repository.AlertaRepository;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.class)
public class BuscaAlertasServiceTest {
	
	@InjectMocks private BuscaAlertasService buscaAlertasService;  
	private List<Alerta> listaDeAlertaMock;
	
	@Mock private AlertaRepository alertaGateway;
	
	private static String DESCRICAO_DEFAULT = "Descrição Teste";
	private static String PONTO_VENDA_DEFAULT = "Ponto de venda Teste";
	private static String PRODUTO_DEFAULT = "Produto Teste";
	
	@Before
	public void setUp(){
		Alerta alerta = new Alerta();
		alerta.setDescricao(DESCRICAO_DEFAULT);
		alerta.setFlTipo(1);
		alerta.setMargem(2);
		alerta.setPontoDeVenda(PONTO_VENDA_DEFAULT);
		alerta.setProduto(PRODUTO_DEFAULT);
		
		listaDeAlertaMock = new ArrayList<>();
		listaDeAlertaMock.add(alerta);
		
		Mockito.when(alertaGateway.findAll())
		.thenReturn(listaDeAlertaMock);
	}
	
	
	@Test
	public void buscarTodosProdutosTest(){
		List<Alerta> buscarTodos = buscaAlertasService.buscarTodos();
		Assert.assertEquals(1, buscarTodos.size());
		Assert.assertEquals(PRODUTO_DEFAULT, buscarTodos.get(0).getProduto());
		Assert.assertEquals(DESCRICAO_DEFAULT, buscarTodos.get(0).getDescricao());
		Assert.assertEquals(PONTO_VENDA_DEFAULT, buscarTodos.get(0).getPontoDeVenda());
		
	}

}
