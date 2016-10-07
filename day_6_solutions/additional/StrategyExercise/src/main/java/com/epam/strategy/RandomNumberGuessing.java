package com.epam.strategy;

import java.util.Random;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("random")
public class RandomNumberGuessing implements NumberGuessingStrategy {

	@Override
	public int guess(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

}
