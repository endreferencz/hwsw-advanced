package com.epam.bridge;

public class Application {

    public static void main(String[] args) {
        BufferedLogger logger = new BufferedLogger(new StdOutLogger());
        logger.log("Hello!");
        logger.flush();
    }

}
