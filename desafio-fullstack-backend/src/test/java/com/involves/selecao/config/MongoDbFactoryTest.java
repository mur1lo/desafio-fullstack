package com.involves.selecao.config;

import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoDbFactoryTest {
	
	private MongoClient client;
	
	public MongoDbFactoryTest() {
		client = MongoClients.create();
	}
	
	public MongoDatabase getDb(){
		String dataBaseName = "selecao_test";
		MongoDatabase database = client.getDatabase(dataBaseName);
		return database;
	}
}
