package com.epam.jpatraining.map.domain;

import javax.persistence.Entity;

@Entity
public class MovePathCommandEntity extends PathCommandEntity {
	@Override
	public String toString() {
		return "M " + getPositionX() + " " + getPositionY();
	}
}
