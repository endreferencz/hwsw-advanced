package com.epam.jpatraining.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.epam.jpatraining.**", 
	excludeFilters = {@ComponentScan.Filter(
			type = FilterType.ASSIGNABLE_TYPE,
			value = { DataSourceConfig.class }
	)})
public class AppConfig {

}
