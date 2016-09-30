package com.epam.bridge;

public class InstantLogger extends Logger {

    public InstantLogger(LoggerImplementor logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }

}
