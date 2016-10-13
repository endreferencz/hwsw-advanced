package com.epam.jpatraining.map.domain;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "pathCommand")
@EntityListeners(AuditListener.class)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PathCommandEntity implements Auditable {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Embedded
	private Audit audit = new Audit();
	
	private BigDecimal positionX;
	
	private BigDecimal positionY;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPositionX() {
		return positionX;
	}

	public void setPositionX(BigDecimal positionX) {
		this.positionX = positionX;
	}

	public BigDecimal getPositionY() {
		return positionY;
	}

	public void setPositionY(BigDecimal positionY) {
		this.positionY = positionY;
	}


	public Audit getAudit() {
		return audit;
	}


	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	
	
}
