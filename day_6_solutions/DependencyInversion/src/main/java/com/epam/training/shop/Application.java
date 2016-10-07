package com.epam.training.shop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.epam.training.shop.store.Store;

public class Application {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("context.xml")) {
            Store store = context.getBean(Store.class);
            store.open();
            store.printPrices();
        }
    }
}
