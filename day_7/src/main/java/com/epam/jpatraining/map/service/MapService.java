package com.epam.jpatraining.map.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.jpatraining.xml.dao.XMLCountiesDao;

@Component
public class MapService {

	@Autowired
	XMLCountiesDao xmlCountiesDao;
	
	@Autowired
	DataSource dataSource;
	
	
//	public void importData() throws IOException, SQLException {
//		StreamSource source = new StreamSource(MapService.class.getResourceAsStream("/input/xml-input-hungary.xml"));
//		XMLCounties xmlCounties = xmlCountiesDao.read(source);
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(
//						"insert into county (id, name, seat, population, size) values (?, ?, ?, ?, ?)")) {
//
//			for (XMLCounty xmlCounty : xmlCounties.getCounties()) {
//				preparedStatement.setString(1, xmlCounty.getId());
//				preparedStatement.setString(2, xmlCounty.getName());
//				preparedStatement.setString(3, xmlCounty.getSeat());
//				preparedStatement.setInt(4, xmlCounty.getPopulation());
//				preparedStatement.setInt(5, xmlCounty.getSize());
//				preparedStatement.executeUpdate();
//			}
//		}
//	}

	
//	public void importData() throws IOException, SQLException {
//
//		StreamSource source = new StreamSource(MapService.class.getResourceAsStream("/input/xml-input-hungary.xml"));
//
//		XMLCounties xmlCounties = xmlCountiesDao.read(source);
//
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//		for (XMLCounty xmlCounty : xmlCounties.getCounties()) {
//			jdbcTemplate.update("insert into county (id, name, seat, population, size) " + "values (?, ?, ?, ?, ?)",
//					xmlCounty.getId(), xmlCounty.getName(), xmlCounty.getSeat(),
//					xmlCounty.getPopulation(), xmlCounty.getSize());
//		}
//	}

	


}
