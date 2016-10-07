package com.epam.strategy;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.epam")
public class Application {

    public static void main(String[] args) throws IOException {
        try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Application.class)) {
            NumberGuessing numberGuessing = context.getBean(NumberGuessing.class);
            numberGuessing.start();
        }
    }

}
