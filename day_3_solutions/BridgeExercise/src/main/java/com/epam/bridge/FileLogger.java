package com.epam.bridge;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements LoggerImplementor {

    @Override
    public void log(String message) {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.append(message + '\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
