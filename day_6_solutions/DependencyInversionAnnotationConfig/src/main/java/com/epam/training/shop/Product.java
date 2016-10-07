package com.epam.training.shop;

import java.math.BigDecimal;

public final class Product {

	private final String name;

	private final BigDecimal price;

	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
