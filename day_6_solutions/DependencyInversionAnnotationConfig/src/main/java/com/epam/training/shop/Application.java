package com.epam.training.shop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.epam.training.shop.store.Store;

@Configuration
@ComponentScan("com.epam")
public class Application {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            Store store = context.getBean(Store.class);
            store.open();
            store.printPrices();
        }
    }
}
