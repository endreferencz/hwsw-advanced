package com.epam.training.shop.store;

import java.math.BigDecimal;

import com.epam.training.shop.Product;
import com.epam.training.shop.data.MemoryDataStore;
import com.epam.training.shop.price.DiscountPriceCalculator;
import com.epam.training.shop.price.ExclusivePriceCalculator;

public class Store {

	private MemoryDataStore<Product> memoryDataStore = new MemoryDataStore<Product>();
	private boolean exclusive;

	public Store() {
	}

	public Store(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public void open() {
		memoryDataStore.add(new Product("Book", new BigDecimal("100")));
		memoryDataStore.add(new Product("UberLaptop", new BigDecimal("10000")));
	}

	public void printPrices() {
		for (Product product : memoryDataStore.list()) {
			BigDecimal price;
			if (exclusive) {
				price = new ExclusivePriceCalculator().price(product);
			} else {
				price = new DiscountPriceCalculator().price(product);
			}
			System.out.println(product.getName() + ": " + price);
		}
	}

	public BigDecimal stock() {
		BigDecimal sum = BigDecimal.ZERO;
		for (Product product : memoryDataStore.list()) {
			BigDecimal price;
			if (exclusive) {
				price = new ExclusivePriceCalculator().price(product);
			} else {
				price = new DiscountPriceCalculator().price(product);
			}
			sum = sum.add(price);
		}
		return sum;
	}

}
