package com.epam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSorter {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();

		List<Long> lines = readNumbers();
		sort(lines);
		printNumbers(lines);

		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
	}

	private static void printNumbers(List<Long> lines) throws IOException {
		StringBuilder result = new StringBuilder();
		for (long l : lines) {
		    result.append(l);
		    result.append("\n");
		}
		try (FileWriter fw = new FileWriter("sorted.txt")) {
			fw.append(result.toString());
			fw.close();
		}
	}

	private static void sort(List<Long> lines) {
		Collections.sort(lines);
	}

	private static List<Long> readNumbers() throws IOException {
		List<Long> lines = new ArrayList<>();
		try (FileReader fr = new FileReader("sortMe.txt")) {
			int nextChar = 0;
			String line = "";
			while ((nextChar = fr.read()) != -1) {
				if (nextChar == '\n') {
					lines.add(Long.valueOf(line));
					line = "";
				} else {
					line = line + (char) nextChar;
				}
			}
		}
		return lines;
	}

}
