package com.epam.training;

public class App {

	private static final int ITERATIONS = 1000000;
	
	private int x = 2;
	private int y = 5;
	
	public int loop(int inter) {
		int s = 0;
		for (int i = 0; i < inter; i++) {
			s += (x + y);
		}
		return s;
	}

	public static void main(String[] args) {
		App app = new App();
		long sum = 0;
		for (int i = 0; i < ITERATIONS; i++) {
			sum += app.loop(ITERATIONS);
		}
		System.out.println(sum);
	}

}
