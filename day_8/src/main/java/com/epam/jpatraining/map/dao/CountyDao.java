package com.epam.jpatraining.map.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.epam.jpatraining.map.domain.CountyEntity;
import com.epam.jpatraining.map.domain.Statistics;

@Component
@Repository
public class CountyDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void create(CountyEntity county) {
		entityManager.persist(county);
	}
	
	public CountyEntity find(long id) {
		return entityManager.find(CountyEntity.class, id);
	}
	
	public void update(CountyEntity countyEntity) {
		entityManager.merge(countyEntity);
	}
	
	public CountyEntity findByName(String name) {
		TypedQuery<CountyEntity> query = entityManager.createQuery("select c from county c where c.name = :name", CountyEntity.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	public CountyEntity findByOrigId(String origId) {
		TypedQuery<CountyEntity> query = entityManager.createQuery("select c from county c where c.origId = :origId", CountyEntity.class);
		query.setParameter("origId", origId);
		return query.getSingleResult();
	}
	
	public Integer findLargestCountySize() {
		TypedQuery<Integer> query = entityManager.createQuery("select max(c.size) from county c", Integer.class);
		return query.getSingleResult();
	}	
	
	public Statistics getStatistics() {
		TypedQuery<Statistics> query = entityManager.createQuery("select "
				+ "new com.epam.jpatraining.map.domain.Statistics(max(c.size), min(c.size), avg(c.size), max(c.population), min(c.population), avg(c.population)) "
				+ "from county c", Statistics.class);
		return query.getSingleResult();
	}
	
	public List<CountyEntity> findAll() {
		TypedQuery<CountyEntity> query = entityManager.createQuery("from county c", CountyEntity.class);
		return query.getResultList();
	}
	
}
