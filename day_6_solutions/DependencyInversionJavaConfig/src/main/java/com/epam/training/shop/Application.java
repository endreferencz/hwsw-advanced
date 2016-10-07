package com.epam.training.shop;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.training.shop.data.DataStore;
import com.epam.training.shop.data.MemoryDataStore;
import com.epam.training.shop.price.DiscountPriceCalculator;
import com.epam.training.shop.price.PriceCalculator;
import com.epam.training.shop.store.Store;

@Configuration
public class Application {

    @Bean
    public Store createStore() {
        return new Store(createDataStore(), createPriceCalculator());
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PriceCalculator createPriceCalculator() {
        return new DiscountPriceCalculator();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataStore<Product> createDataStore() {
        return new MemoryDataStore<>();
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            Store store = context.getBean(Store.class);
            store.open();
            store.printPrices();
        }
    }
}
