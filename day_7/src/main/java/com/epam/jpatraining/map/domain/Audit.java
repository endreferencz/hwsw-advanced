package com.epam.jpatraining.map.domain;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Audit {

	private LocalDate created;

	private String createdBy;

	private LocalDate updated;
	
	private String updatedBy;

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	
	

	
	
	
}
