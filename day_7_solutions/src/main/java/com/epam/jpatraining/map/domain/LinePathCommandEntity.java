package com.epam.jpatraining.map.domain;

import javax.persistence.Entity;

@Entity
public class LinePathCommandEntity extends PathCommandEntity {

	private boolean relative;

	public boolean isRelative() {
		return relative;
	}

	public void setRelative(boolean relative) {
		this.relative = relative;
	}
	
	@Override
	public String toString() {
		return (relative ? "l" : "L") + " " + getPositionX() + " " + getPositionY();
	}
}
