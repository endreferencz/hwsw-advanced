package com.epam.training.template.data;

import java.math.BigDecimal;

public class Dimensions {

	private final BigDecimal width;
	private final BigDecimal height;
	private final BigDecimal depth;

	public Dimensions(BigDecimal width, BigDecimal height, BigDecimal depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public BigDecimal getDepth() {
		return depth;
	}

	public BigDecimal getVolume() {
		return width.multiply(depth).multiply(height);
	}

}
