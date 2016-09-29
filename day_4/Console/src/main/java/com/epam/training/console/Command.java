package com.epam.training.console;

import java.io.File;

public abstract class Command {

    protected File currentDirectory;

    public Command(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public abstract boolean shouldExecute(String command);

    public abstract void execute(String command);

}
