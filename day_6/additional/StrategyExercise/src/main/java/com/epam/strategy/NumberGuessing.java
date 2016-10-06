package com.epam.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGuessing {

	public static void main(String[] args) throws IOException {
		new NumberGuessing(new RandomNumberGuessing()).start();
	}

	private NumberGuessingStrategy strategy;

	public NumberGuessing(NumberGuessingStrategy strategy) {
		this.strategy = strategy;
	}

	public void start() throws IOException {
		int min = 0;
		int max = 1023;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			boolean finished = false;
			while (!finished) {
				int guess = strategy.guess(min, max);
				System.out.println(guess);
				String input = br.readLine();
				String simpleInput = input.trim();
				if (simpleInput.startsWith(">")) {
					min = guess + 1;
				} else if (simpleInput.startsWith("<")) {
					max = guess - 1;
				} else {
					System.out.println("It was: " + guess);
					finished = true;
				}
			}
		}
	}

}
