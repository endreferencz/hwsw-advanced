package com.epam.jpatraining.config;

import org.springframework.context.annotation.Bean;

import freemarker.template.Configuration;

//@org.springframework.context.annotation.Configuration
public class FreemarkerConfig {

	@Bean
	public Configuration freemarkerConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(this.getClass(), "/template");
		return configuration;
	}
}
