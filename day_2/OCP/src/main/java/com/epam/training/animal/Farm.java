package com.epam.training.animal;

import java.util.Arrays;
import java.util.List;

public class Farm {

	private List<Animal> animals = Arrays.asList(Animal.DOG, Animal.DOG,
			Animal.DOG, Animal.CAT, Animal.DUCK);

	public void sing() {
		for (Animal animal : animals) {
			speak(animal);
		}
	}

	private void speak(Animal animal) {
		if (animal == Animal.CAT) {
			System.out.println("Meow!");
		} else if (animal == Animal.DOG) {
			System.out.println("Woof!");
		} else if (animal == Animal.DUCK) {
			System.out.println("Quack!");
		}
	}

}
