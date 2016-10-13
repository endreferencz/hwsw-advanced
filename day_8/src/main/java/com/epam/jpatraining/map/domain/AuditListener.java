package com.epam.jpatraining.map.domain;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;

import com.epam.jpatraining.context.UserContext;

public class AuditListener {

	@PrePersist
	public void prePersist(Auditable auditable) {
		auditable.getAudit().setCreated(LocalDateTime.now()); 
		auditable.getAudit().setCreatedBy(UserContext.getUser());
	}
}
