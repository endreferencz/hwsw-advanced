package com.epam.training.shop.price;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epam.training.shop.Product;

@Component
@Qualifier("discount")
public class DiscountPriceCalculator implements PriceCalculator {

    private double ratio;

    public DiscountPriceCalculator(@Value("1.1") double ratio) {
        this.ratio = ratio;
    }

    public BigDecimal price(Product product) {
        return product.getPrice().multiply(BigDecimal.valueOf(ratio));
    }

}
