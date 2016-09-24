package com.epam.bridge;

public class StdOutInstantLogger implements InstantLogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

}
