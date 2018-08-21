package com.involves.selecao.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.involves.selecao.SelecaoApplication;
import com.involves.selecao.domain.Alerta;
import com.involves.selecao.service.BuscaAlertasService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SelecaoApplication.class)
public class AlertaRestTest {

	@Autowired
	private AlertaRest alertaRest;

	@Autowired
	private HttpMessageConverter[] httpMessageConverters;

	@Autowired
	private BuscaAlertasService alertasService;

	private MockMvc restMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.restMvc = MockMvcBuilders.standaloneSetup(alertaRest).setMessageConverters(httpMessageConverters).build();
	}

	@Test
	public void alertasProcessarIsOk() throws Exception {
		restMvc.perform(get("/alertas/processar")).andExpect(status().isOk());
		List<Alerta> buscarTodos = alertasService.buscarTodos();
		Assert.assertEquals(true, buscarTodos.size() > 0);
		System.out.println(buscarTodos);
	}

	@Test
	public void alertasProcessarIsNotFound() throws Exception {
		restMvc.perform(get("/alertas/p")).andExpect(status().isNotFound());
	}
}
