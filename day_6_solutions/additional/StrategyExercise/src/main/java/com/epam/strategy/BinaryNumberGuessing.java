package com.epam.strategy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("binary")
public class BinaryNumberGuessing implements NumberGuessingStrategy {

	@Override
	public int guess(int min, int max) {
		return (min + max) / 2;
	}

}
