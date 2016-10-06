package com.epam.strategy;

import java.util.Random;

public class RandomNumberGuessing implements NumberGuessingStrategy {

	@Override
	public int guess(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

}
