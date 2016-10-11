package com.epam.jpatraining.xml.domain;

import java.math.BigDecimal;

import com.epam.jpatraining.common.SVGPathCommandType;

public class XMLPathCommand {

	private SVGPathCommandType type;
	private BigDecimal positionX;
	private BigDecimal positionY;
	
	public SVGPathCommandType getType() {
		return type;
	}
	public void setType(SVGPathCommandType type) {
		this.type = type;
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
	
	
	
	
	
	
	
	
	
}
