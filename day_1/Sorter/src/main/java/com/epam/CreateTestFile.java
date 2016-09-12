package com.epam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateTestFile {

	private static final int NUMBER_COUNT = 1_000_000;
    private static final String OUTPUT_FILE_NAME = "sortMe.txt";

	public static void main(String[] args) throws IOException {
		Random random = new Random();
		FileWriter fw = new FileWriter(OUTPUT_FILE_NAME);
		for (int i = 0; i < NUMBER_COUNT; i++) {
			fw.append("" + random.nextInt(NUMBER_COUNT) + "\n");
		}
		fw.close();
	}
	
}
