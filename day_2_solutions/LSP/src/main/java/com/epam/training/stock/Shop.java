package com.epam.training.stock;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Shop {

    private List<Item> items = Arrays.asList(
            (Item) new Book("Elements of Reusable Object-Oriented Software", new BigDecimal("100"))
            );

    public BigDecimal stock() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(item.value());
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Shop().stock());
    }

}
