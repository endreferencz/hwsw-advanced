package com.epam.jpatraining.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.repository.CityRepository;
import com.epam.jpatraining.map.repository.CountyRepository;

@Component
public class CountryService {

	@Autowired
	CountyRepository countyRepository;

//	@Autowired
//	CityRepository cityRepository;
	
	public CountyEntity findById(long id) {
		return countyRepository.findOne(id);
	}

	
	@Transactional
	public CountyEntity findCountyByOrigIdOrName(String value) {
		return countyRepository.findByNameOrOrigId(value, value);
	}
	
//	public Integer findLargestCounty(int size) {
//		return countyRepository.findLargestCountySize(size);
//	}
		
	@Transactional
	public void save(CountyEntity countyEntity) {
		countyRepository.save(countyEntity);
		System.out.printf("CountyEntity saved: %s\n", countyEntity.getId());
		System.out.println(countyRepository.sayHello());
		
	}
	

	public Iterable<CountyEntity> findAll(Pageable pageable) {
		return countyRepository.findAll(pageable);
	}
	
	public Iterable<CountyEntity> findAll() {
		return countyRepository.findAll();
	}
	
//	public Statistics getStatistics() {
//		return countyRepository.getStatistics();
//	}

//	@Transactional(timeout = 1)
//	public long countCity() {
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return cityRepository.count();
//	}
	
	
	

}
