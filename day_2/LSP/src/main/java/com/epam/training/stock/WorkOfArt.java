package com.epam.training.stock;

import java.math.BigDecimal;

public class WorkOfArt implements Item {

    private String name;

    private BigDecimal startingPrice;

    private BigDecimal finalPrice = null;

    public WorkOfArt(String name, BigDecimal startingPrice) {
        this.name = name;
        this.startingPrice = startingPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public BigDecimal value() {
        if (finalPrice == null) {
            throw new IllegalStateException("Unknown value!");
        }
        return finalPrice;
    }

    @Override
    public String toString() {
        return "WorkOfArt [name=" + name + ", startingPrice=" + startingPrice + "]";
    }

}
