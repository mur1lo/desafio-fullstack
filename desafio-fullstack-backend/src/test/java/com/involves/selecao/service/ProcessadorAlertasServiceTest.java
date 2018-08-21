package com.involves.selecao.service;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.involves.selecao.SelecaoApplication;
import com.involves.selecao.domain.Alerta;
import com.involves.selecao.domain.enumeration.TipoAlerta;
import com.involves.selecao.repository.AlertaRepository;
import com.involves.selecao.utils.Constants;
import com.involves.selecao.utils.HttpClientHelper;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SelecaoApplication.class)
public class ProcessadorAlertasServiceTest {

	@Autowired
	@InjectMocks
	ProcessadorAlertasService alertasService;

	@Autowired
	private AlertaRepository alertaRepository;

	@Mock
	private HttpClientHelper clientHelper;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void produtoAusenteNaGondulatest() throws IOException {
		String response = "[{\"id\":\"1\",\"rotulo\":\"Campanha de pascoa\",\"notificante\":\"João\",\"ponto_de_venda\":\"Angel One Capoeiras\",\"produto\":\"Ovo de Pascoa Kinder 48\",\"respostas\":[{\"pergunta\":\"Qual a situação do produto?\",\"resposta\":\""
				+ Constants.PRODUTO_AUSENTE_GONDOLA + "\"}]}]";
		ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		Mockito.doReturn(responseEntity).when(clientHelper)
				.doGet("https://selecao-involves.agilepromoter.com/pesquisas", null);

		alertasService.processa();
		
		List<Alerta> findAll = alertaRepository.findAll();
		Alerta alerta = findAll.stream().findFirst().orElse(null);
		Assert.assertEquals(1, findAll.size());
		Assert.assertEquals(Constants.RUPTURA_DETECTADA, alerta.getDescricao());
		Assert.assertEquals(TipoAlerta.RUPTURA.getValor().toString(), alerta.getFlTipo().toString());
		Assert.assertEquals("Angel One Capoeiras", alerta.getPontoDeVenda());
		Assert.assertEquals("Ovo de Pascoa Kinder 48", alerta.getProduto());

	}
}
