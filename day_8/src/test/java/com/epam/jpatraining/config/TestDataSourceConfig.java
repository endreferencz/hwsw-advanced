package com.epam.jpatraining.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class TestDataSourceConfig {



	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public DataSource dataSource() {
		//return new DriverManagerDataSource("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		return new DriverManagerDataSource("jdbc:h2:tcp://localhost:9092/../database/test");
	}
}
