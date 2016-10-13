package com.epam.jpatraining;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.epam.jpatraining.config.DataSourceConfig;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws IOException, SQLException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class, DataSourceConfig.class)) {
			// Business logic starts here...


		}
	}

}
