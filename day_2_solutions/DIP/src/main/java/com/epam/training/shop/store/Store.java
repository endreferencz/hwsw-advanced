package com.epam.training.shop.store;

import java.math.BigDecimal;

import com.epam.training.shop.Product;
import com.epam.training.shop.data.DataStore;
import com.epam.training.shop.price.PriceCalculator;

public class Store {

	private PriceCalculator priceCalculator;
	private DataStore<Product> dataStore;

	public Store() {
	}

	public Store(PriceCalculator priceCalculator, DataStore<Product> dataStore) {
		this.priceCalculator = priceCalculator;
		this.dataStore = dataStore;
	}

	public void open() {
		dataStore.add(new Product("Book", new BigDecimal("100")));
		dataStore.add(new Product("UberLaptop", new BigDecimal("10000")));
	}

	public void printPrices() {
		for (Product product : dataStore.list()) {
			System.out.println(product.getName() + ": " + priceCalculator.price(product));
		}
	}

	public BigDecimal stock() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : dataStore.list()) {
			sum = sum.add(priceCalculator.price(product));
		}
		return sum;
	}

}
