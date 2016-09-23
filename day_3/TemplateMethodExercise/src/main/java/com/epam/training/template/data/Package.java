package com.epam.training.template.data;

import java.math.BigDecimal;

public class Package {

	private final BigDecimal weight;
	private final Dimensions dimensions;

	public Package(BigDecimal weight, Dimensions dimensions) {
		this.weight = weight;
		this.dimensions = dimensions;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public Dimensions getDimensions() {
		return dimensions;
	}

	public BigDecimal getVolume() {
		return dimensions.getVolume();
	}

}
