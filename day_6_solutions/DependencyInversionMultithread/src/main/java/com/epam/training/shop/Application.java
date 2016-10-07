package com.epam.training.shop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.epam.training.shop.store.Store;

@Configuration
@ComponentScan("com.epam")
public class Application {

    private static class StoreUser implements Runnable {

        private Store store;

        public StoreUser(Store store) {
            this.store = store;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                store.open();
            }
        }

    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            startUser(context);
            startUser(context);
            startUser(context);
            startUser(context);
            startUser(context);
            startUser(context);
        }
    }

    private static void startUser(ConfigurableApplicationContext context) {
        Store store = context.getBean(Store.class);
        new Thread(new StoreUser(store)).start();
    }
}
