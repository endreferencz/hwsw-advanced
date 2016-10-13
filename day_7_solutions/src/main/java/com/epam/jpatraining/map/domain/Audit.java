package com.epam.jpatraining.map.domain;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class Audit {

	private LocalDateTime created;

	private String createdBy;

	private LocalDateTime updated;
	
	private String updatedBy;

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
	
}
