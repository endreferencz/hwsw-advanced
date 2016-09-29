package com.epam.training.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Console {

    private File currentDirectory = new File(".").getAbsoluteFile();
    private List<Command> commands = Arrays.asList((Command) new Cd(currentDirectory));

    public static void main(String[] args) throws IOException {
        new Console().start();
    }

    private void start() throws IOException {
        System.out.println("Console 0.1");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String command;
            do {
                command = reader.readLine().trim();
                for (Command c : commands) {
                    if (c.shouldExecute(command)) {
                        c.setCurrentDirectory(currentDirectory);
                        c.execute(command);
                        currentDirectory = c.getCurrentDirectory();
                    }
                }
            } while (!command.equals("exit"));
        }
    }

}
