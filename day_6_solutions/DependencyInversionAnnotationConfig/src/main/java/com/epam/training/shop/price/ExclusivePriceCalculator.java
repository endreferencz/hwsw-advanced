package com.epam.training.shop.price;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.epam.training.shop.Product;

@Component
@Qualifier("exclusive")
public class ExclusivePriceCalculator implements PriceCalculator {

	public BigDecimal price(Product product) {
		return product.getPrice().multiply(new BigDecimal("2"));
	}

}
