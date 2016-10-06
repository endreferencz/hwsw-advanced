package com.epam.strategy;

public class BinaryNumberGuessing implements NumberGuessingStrategy {

	@Override
	public int guess(int min, int max) {
		return (min + max) / 2;
	}

}
