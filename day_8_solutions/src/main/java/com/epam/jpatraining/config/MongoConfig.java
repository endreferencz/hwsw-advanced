package com.epam.jpatraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories("com.epam.jpatraining.map.repository")
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "hwsw";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		
		MongoClientURI uri = new MongoClientURI("mongodb://hwsw:hwsw123@ds057066.mlab.com:57066/?authSource=hwsw");
		return new MongoClient(uri);
	}
	
}
