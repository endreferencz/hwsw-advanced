package com.epam.jpatraining;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.jpatraining.config.AppConfig;
import com.epam.jpatraining.config.TestDataSourceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class, AppConfig.class} )
public abstract class AbstractIntegrationTest {
	
	@Autowired
	DataSource dataSource;
	
	@Before
	public void populateDatabase() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/scripts/populate-database.sql"));
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
	
	
}
