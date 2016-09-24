package com.epam.training.shop.price;

import java.math.BigDecimal;

import com.epam.training.shop.Product;

public class DiscountPriceCalculator implements PriceCalculator {

	@Override
	public BigDecimal price(Product product) {
		return product.getPrice().multiply(new BigDecimal("0.9"));
	}

}
