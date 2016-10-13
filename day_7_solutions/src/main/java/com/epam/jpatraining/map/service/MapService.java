package com.epam.jpatraining.map.service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpatraining.common.SVGPathCommandType;
import com.epam.jpatraining.map.dao.CountyDao;
import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.LinePathCommandEntity;
import com.epam.jpatraining.map.domain.MovePathCommandEntity;
import com.epam.jpatraining.map.domain.PathCommandEntity;
import com.epam.jpatraining.map.domain.Statistics;
import com.epam.jpatraining.xml.dao.XMLCountiesDao;
import com.epam.jpatraining.xml.domain.XMLCounties;
import com.epam.jpatraining.xml.domain.XMLCounty;
import com.epam.jpatraining.xml.domain.XMLPathCommand;

import freemarker.template.TemplateException;

@Component
public class MapService {

	@Autowired
	XMLCountiesDao xmlCountiesDao;
	
	@Autowired
	CountyDao countyDao;
	
	@Autowired 
	TemplateService templateService;
	
	
	@Transactional
	public void importData() throws IOException, SQLException {
		StreamSource source = new StreamSource(MapService.class.getResourceAsStream("/input/xml-input-hungary.xml"));

		XMLCounties xmlCounties = xmlCountiesDao.read(source);
		
		for (XMLCounty xmlCounty : xmlCounties.getCounties()) {
			CountyEntity county = createCounty(xmlCounty);
			
			List<PathCommandEntity> pathCommands = new LinkedList<>();
			
			xmlCounty.getPathCommands().forEach(xmlPathCommand -> {
				createPathCommand(pathCommands, xmlPathCommand);
			});
			
			county.setPathCommands(pathCommands);
			countyDao.create(county);
			}
	}
	
	

	@Transactional
	public void update(CountyEntity countyEntity) {
		countyDao.update(countyEntity);
	}



	@Transactional
	public CountyEntity findByName(String name) {
		CountyEntity result = countyDao.findByName(name);
		return result;
	}


	
	public Integer findLargestCountySize() {
		return countyDao.findLargestCountySize();
	}
	
	

	public Statistics getStatistics() {
		return countyDao.getStatistics();
	}

	public void generateSVG() throws IOException, TemplateException {
		List<CountyEntity> counties = countyDao.findAll();
		
		List<String> coordinates = new LinkedList<>();
		counties.forEach(county -> {
			StringBuffer command = new StringBuffer();
			county.getPathCommands().forEach(pathCommand -> {
				command.append(pathCommand.toString()).append(" ");
			});
			//command.append("z");
			coordinates.add(command.toString());			
		});
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("coordinates", coordinates);

		templateService.create(new FileWriter("../map.svg"), "map-template.xml", data);
		
		
		

	}
	
	private CountyEntity createCounty(XMLCounty xmlCounty) {
		CountyEntity county = new CountyEntity();
		
		county.setIdOrig(xmlCounty.getId());
		county.setName(xmlCounty.getName());
		county.setSeat(xmlCounty.getSeat());
		county.setColor(xmlCounty.getColor());
		county.setPopulation(xmlCounty.getPopulation());
		county.setSize(xmlCounty.getSize());
		return county;
	}
	
	private void createPathCommand(List<PathCommandEntity> pathCommands, XMLPathCommand xmlPathCommand) {
		SVGPathCommandType pathCommandType = xmlPathCommand.getType();
		PathCommandEntity pathCommand;
		
		
		if (pathCommandType == SVGPathCommandType.L) {
			pathCommand = new LinePathCommandEntity();
		}
		else if (pathCommandType == SVGPathCommandType.l) {
			pathCommand = new LinePathCommandEntity();
			((LinePathCommandEntity)pathCommand).setRelative(true);
		}
		else {
			pathCommand = new MovePathCommandEntity();
		}

		pathCommand.setPositionX(xmlPathCommand.getPositionX());
		pathCommand.setPositionY(xmlPathCommand.getPositionY());
		pathCommands.add(pathCommand);
	}
	
	


}
