package com.epam.training.shop.store;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.epam.training.shop.Product;
import com.epam.training.shop.data.DataStore;
import com.epam.training.shop.price.PriceCalculator;

@Component
public class Store {

    @Inject
    private DataStore<Product> dataStore;

    @Autowired
    @Qualifier("discount")
    private PriceCalculator priceCalculator;

    public Store() {
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
