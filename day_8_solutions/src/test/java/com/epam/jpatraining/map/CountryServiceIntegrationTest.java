package com.epam.jpatraining.map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.epam.jpatraining.AbstractIntegrationTest;
import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.service.CountryService;

public class CountryServiceIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	CountryService countryService;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Test
	public void testSaveCounty() {
		// Given
		CountyEntity county = new CountyEntity();
		county.setId(2);
		county.setName("TestCounty");
		county.setColor("test color");
		county.setOrigId("Test orig ID");
		county.setPopulation(100);
		county.setSize(100);
		
		// When
		countryService.save(county);
		
		// Then
		//Assert.assertEquals("Cannot create entity.", entityManager.find(CountyEntity.class, county.getId()), county);
	}
	
//	@Test
//	public void testStatistics() {
//		System.out.println(countryService.getStatistics());
//	}
//	
	@Test
	public void testFindByNameOrOrigId() {
		// Given
		String origId = "HU-BK";
		
		// When 
		CountyEntity result = countryService.findCountyByOrigIdOrName(origId);
				
		// Then
		Assert.assertEquals(1, result.getId());
	}
	
//	@Test
//	public void testFindLargest() {
//		Integer size1 = countryService.findLargestCounty(1000);
//		Integer size2 = countryService.findLargestCounty(10000);
//		
//		System.out.println(size1);
//		System.out.println(size2);
//	}
	
	@Test
	public void testPaging() {
		PageRequest request =
	            new PageRequest(2, 5, Sort.Direction.DESC, "name"); 
		Iterable<CountyEntity> result = countryService.findAll(request);
		
		System.out.println(result);
		result.forEach(county -> System.out.println(county));
		
	}
	
//	@Test
//	public void testCountCity() {
//		System.out.println(countryService.countCity());
//	}
}
