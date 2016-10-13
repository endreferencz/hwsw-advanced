package com.epam.jpatraining.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpatraining.map.dao.CountyDao;
import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;

@Component
public class CountryService {

	@Autowired
	CountyDao countyDao;

	public CountyEntity findById(long id) {
		return countyDao.find(id);
	}

	
	@Transactional
	public CountyEntity findCountyByOrigIdOrName(String name) {
		CountyEntity countyEntity = countyDao.findByOrigId(name);
		if (countyEntity == null) {			
			countyEntity = countyDao.findByName(name);
		}
		return countyEntity;
	}
	
	public Integer findLargestCounty() {
		return countyDao.findLargestCountySize();
	}
		
	@Transactional
	public void update(CountyEntity countyEntity) {
		countyDao.update(countyEntity);
	}
	
	@Transactional
	public void create(CountyEntity countyEntity) {
		countyDao.create(countyEntity);
	}
	
	public List<CountyEntity> findAll() {
		return countyDao.findAll();
	}
	
	public Statistics getStatistics() {
		return countyDao.getStatistics();
	}
	
	

}
