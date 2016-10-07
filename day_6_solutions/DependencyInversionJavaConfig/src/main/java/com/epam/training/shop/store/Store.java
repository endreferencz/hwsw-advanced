package com.epam.training.shop.store;

import java.math.BigDecimal;

import com.epam.training.shop.Product;
import com.epam.training.shop.data.DataStore;
import com.epam.training.shop.price.PriceCalculator;

public class Store {

    private DataStore<Product> dataStore;
    private PriceCalculator priceCalculator;

    public Store(DataStore<Product> dataStore, PriceCalculator priceCalculator) {
        this.dataStore = dataStore;
        this.priceCalculator = priceCalculator;
    }

    public void open() {
        dataStore.add(new Product("Book", new BigDecimal("100")));
        dataStore.add(new Product("UberLaptop", new BigDecimal("10000")));
    }

    public void printPrices() {
        for (Product product : dataStore.list()) {
            BigDecimal price = priceCalculator.price(product);
            System.out.println(product.getName() + ": " + price);
        }
    }

    public BigDecimal stock() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : dataStore.list()) {
            BigDecimal price = priceCalculator.price(product);
            sum = sum.add(price);
        }
        return sum;
    }

}
