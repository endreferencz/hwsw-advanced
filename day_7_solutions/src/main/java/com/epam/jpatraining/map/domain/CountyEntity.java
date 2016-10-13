package com.epam.jpatraining.map.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity(name = "county")
@EntityListeners(AuditListener.class)
public class CountyEntity implements Auditable {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Version
	private int version;
	
	@Embedded
	private Audit audit = new Audit();
	
	
	@Column(nullable = false)
	private String idOrig;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String seat;
	
	@Column(nullable = false)
	private String color;
	
	@Column(nullable = false)
	private int population;
	
	@Column(nullable = false)
	private int size;
	
	@Transient
	private String fullName;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<PathCommandEntity> pathCommands;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getIdOrig() {
		return idOrig;
	}

	public void setIdOrig(String idOrig) {
		this.idOrig = idOrig;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public List<PathCommandEntity> getPathCommands() {
		return pathCommands;
	}

	public void setPathCommands(List<PathCommandEntity> pathCommands) {
		this.pathCommands = pathCommands;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public String getFullName() {
		if (fullName == null) {
			fullName = idOrig + " " + name;
		}
		return fullName;
	}
	
	
	
}
