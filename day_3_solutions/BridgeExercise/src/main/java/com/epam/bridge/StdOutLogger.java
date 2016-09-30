package com.epam.bridge;

public class StdOutLogger implements LoggerImplementor {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

}
