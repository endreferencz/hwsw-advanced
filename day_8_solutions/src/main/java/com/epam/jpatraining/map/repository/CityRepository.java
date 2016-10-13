package com.epam.jpatraining.map.repository;

import org.springframework.data.repository.Repository;

import com.epam.jpatraining.map.domain.CityEntity;
import com.epam.jpatraining.map.domain.CountyEntity;

public interface CityRepository extends Repository<CityEntity, Long> {
	
	CountyEntity findOne(Long id);
	boolean exists(Long id);
	Iterable<CountyEntity> findAll();
	Iterable<CountyEntity> findAll(Iterable<Long> ids);
	long count();
}
