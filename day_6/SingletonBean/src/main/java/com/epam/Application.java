package com.epam;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    @Bean
    public Shop createShop() {
        return new Shop(createDataStore());
    }

    @Bean
    public Stock createStock() {
        return new Stock(createDataStore());
    }

    public DataStore createDataStore() {
        return new DataStore();
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {

        }
    }

}
