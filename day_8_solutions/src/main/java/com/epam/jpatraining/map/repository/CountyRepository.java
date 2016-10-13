package com.epam.jpatraining.map.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;


public interface CountyRepository extends PagingAndSortingRepository<CountyEntity, Long>, CountyRepositoryCustom {

	CountyEntity findByNameOrOrigId(String name, String origId);

//	@Query("select max(c.size) from county c where size > :size")
//	Integer findLargestCountySize(@Param("size") int size);

//	@Query("select "
//				+ "new com.epam.jpatraining.map.domain.Statistics(max(c.size), min(c.size), avg(c.size), max(c.population), min(c.population), avg(c.population)) "
//				+ "from county c")
//	Statistics getStatistics();

}
