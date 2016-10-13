package com.epam.jpatraining.map.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name = "city")
public class CityEntity {

	@Id
	@GeneratedValue
	private long id;
	
	@Version
	private Integer version;
	
	@Column(nullable = false)	
	private String name;
	
	@Column(nullable = false)
	private int population;
	
	@Column(nullable = false)
	private int size;

	

	@Embedded
	private Audit audit = new Audit();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	
}
