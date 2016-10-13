package com.epam.jpatraining;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.oxm.XmlMappingException;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.service.MapService;

import freemarker.template.TemplateException;

/**
 * Map creator application
 *
 */
public class App {

	public static void main(String[] args) throws XmlMappingException, IOException, SQLException, TemplateException {
		try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				"com.epam.jpatraining.config")) {

			MapService mapService = context.getBean(MapService.class);

			//mapService.importData();
			
			
			mapService.generateSVG();
//			CountyEntity bp = mapService.findByName("Budapest");
//			bp.setPopulation(bp.getPopulation() + 10);
//			mapService.update(bp);
			
//			System.out.println(mapService.findByName("Budapest").getPathCommands().size());
//			System.out.println(mapService.findLargestCountySize());
//			System.out.println(mapService.getStatistics());

		}

	}
}
