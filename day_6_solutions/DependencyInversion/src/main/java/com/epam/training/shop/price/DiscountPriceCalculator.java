package com.epam.training.shop.price;

import java.math.BigDecimal;

import com.epam.training.shop.Product;

public class DiscountPriceCalculator implements PriceCalculator {

    private double ratio;

    public DiscountPriceCalculator(double ratio) {
        this.ratio = ratio;
    }

    public BigDecimal price(Product product) {
        return product.getPrice().multiply(BigDecimal.valueOf(ratio));
    }

}
