package com.epam.jpatraining;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.transform.stream.StreamSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.oxm.XmlMappingException;

import com.epam.jpatraining.xml.dao.XMLCountiesDao;
import com.epam.jpatraining.xml.domain.XMLCounties;

import freemarker.template.TemplateException;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws XmlMappingException, IOException, SQLException, TemplateException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				"com.epam.jpatraining.config")) {

			XMLCountiesDao xmlCountiesDao = context.getBean(XMLCountiesDao.class);			
			StreamSource source = new StreamSource(App.class.getResourceAsStream("/input/xml-input-hungary.xml"));						
			XMLCounties xmlCounties = xmlCountiesDao.read(source);						
			xmlCounties.getCounties().forEach(county -> System.out.println(county.getName()));

			
			
//			MapService mapService = context.getBean(MapService.class);
//
//			mapService.importData();

		}

	}
}
