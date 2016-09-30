package com.epam.bridge;

public class BufferedLogger extends Logger {

    private StringBuilder buffer = new StringBuilder();

    public BufferedLogger(LoggerImplementor logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        buffer.append(message);
    }

    public void flush() {
        logger.log(buffer.toString());
        buffer.setLength(0);
    }

}
