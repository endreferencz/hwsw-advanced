package com.epam.bridge;

public abstract class Logger {

    protected LoggerImplementor logger;

    public Logger(LoggerImplementor logger) {
        this.logger = logger;
    }

    public abstract void log(String message);

}
