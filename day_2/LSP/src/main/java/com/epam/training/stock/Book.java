package com.epam.training.stock;

import java.math.BigDecimal;

public class Book implements Item {

    private String title;
    private BigDecimal price;

    public Book(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public BigDecimal value() {
        return price.multiply(new BigDecimal("0.6"));
    }

    @Override
    public String toString() {
        return "Book [title=" + title + "]";
    }

}
