package com.epam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckFiles {

	public static void main(String[] args) throws IOException {
		System.out.println("Test result: " + (sum("sortMe.txt") == sum("sorted.txt")));
	}

	private static long sum(String fileName) throws IOException {
		try (FileReader fr = new FileReader(fileName)) {
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			long sum = 0;
			while (line != null) {
				sum += Long.valueOf(line);
				line = br.readLine();
			}
			return sum;
		}
	}
}
