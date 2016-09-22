package com.epam.training.console;

import java.io.File;

public class Cd extends Command {

	public Cd(File currentDirectory) {
		super(currentDirectory);
	}

	@Override
	public void execute(String command) {
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
	}

	@Override
	public boolean shouldExecute(String command) {
		return command.startsWith("cd");
	}

}
