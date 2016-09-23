package com.epam.bridge;

public class StdOutBufferedLogger implements BufferedLogger {

    private StringBuilder builder = new StringBuilder();
    
    @Override
    public void log(String message) {
        builder.append(message + '\n');
    }

    @Override
    public void flush() {
        System.out.println(builder.toString());
        builder.setLength(0);
    }

}
