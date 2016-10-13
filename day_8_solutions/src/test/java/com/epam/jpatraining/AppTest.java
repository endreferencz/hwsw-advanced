package com.epam.jpatraining;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.jpatraining.config.AppConfig;
import com.epam.jpatraining.config.TestDataSourceConfig;

public class AppTest {

	@Test
	@SuppressWarnings("resource")
	public void bootstrapsApplication() {
		new AnnotationConfigApplicationContext(AppConfig.class, TestDataSourceConfig.class);
	}
}
