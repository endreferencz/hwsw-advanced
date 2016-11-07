package com.epam.training;

public class App {
	
	private static final int ITERATIONS = 100000000;
	private int number = 32;
	
	public int reduction() {
		number = number * 33;
		return number;
	}
	
	public static void main(String[] args) {
		App app = new App();
		long sum = 0;
		for (int i = 0; i < ITERATIONS; i++) {
			sum += app.reduction();
		}
		System.out.println(sum);
	}

}
