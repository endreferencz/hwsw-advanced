package com.epam.training.animal;

import java.util.Arrays;
import java.util.List;

public class Farm {

	private List<Animal> animals = Arrays.asList(new Dog(), new Cat(), new Cat());

	public void sing() {
		for (Animal animal : animals) {
			animal.speak();
		}
	}

}
