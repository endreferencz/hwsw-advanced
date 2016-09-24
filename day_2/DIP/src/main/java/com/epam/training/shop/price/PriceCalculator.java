package com.epam.training.shop.price;

import java.math.BigDecimal;

import com.epam.training.shop.Product;

public interface PriceCalculator {

    BigDecimal price(Product product);

}