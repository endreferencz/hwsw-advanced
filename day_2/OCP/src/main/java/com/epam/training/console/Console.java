package com.epam.training.console;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    
    private File currentDirectory = new File(".");
    
    public static void main(String[] args) throws IOException {
        new Console().start();
    }

    private void start() throws IOException {
        System.out.println("Console 0.1");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String command;
            do {
                command = reader.readLine().trim();
                if (command.equals("ls")) {
                    for (File file : currentDirectory.listFiles()) {
                        System.out.print(String.format("%1$-15s", file.getName()));
                        if (file.isDirectory()) {
                            System.out.print("\tf");
                            System.out.println("\t" + file.length());
                        } else {
                            System.out.println("\td");
                        }
                        
                    }
                } else if (command.startsWith("cd")) {
                    if (command.startsWith("cd ..")) {
                        currentDirectory = currentDirectory.getParentFile();
                    } else {
                        File newDirectory = new File(currentDirectory, command.substring(3, command.length()));
                        if (newDirectory.isDirectory() && newDirectory.exists()) {
                            currentDirectory = newDirectory;
                        } else {
                            System.out.println("Invalid directory");
                        }
                    }
                } else if (command.equals("pwd")) {
                    System.out.println(currentDirectory.getCanonicalFile());                    
                } else if (!command.equals("exit")) {
                    System.out.println("Invalid command: " + command);
                }
            } while (!command.equals("exit"));
        }
    }

}
