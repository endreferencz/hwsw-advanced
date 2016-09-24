package com.epam.bridge;

import java.io.FileWriter;
import java.io.IOException;

public class FileBufferedLogger implements BufferedLogger {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void log(String message) {
        builder.append(message + '\n');
    }

    @Override
    public void flush() {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.append(builder.toString() + '\n');
            builder.setLength(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
