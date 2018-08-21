package com.involves.selecao.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.involves.selecao.config.MongoDbFactoryTest;
import com.mongodb.client.MongoDatabase;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AlertaMongoRepositoryTest {

	@Autowired
	private MongoDbFactoryTest mongoFactory;
	
	private MongoDatabase database;
	
	@Before
	public void setUp(){
		database = mongoFactory.getDb();
	}
	
	@Test
	public void testDb(){
//		database.createCollection("teste");
	}
}
