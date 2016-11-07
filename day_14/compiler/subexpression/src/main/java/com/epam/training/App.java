package com.epam.training;

public class App {

	private static final int ITERATIONS = 100000000;
	
	private int b = 2;
	private int c = 3;
	private int g = 4;
	private int e = 5;
	
	public int subexpression() {
		int a = b * c + g;
		int d = b * c * e;
		
		return a + d;
	}

	public static void main(String[] args) {
		App app = new App();
		long sum = 0;
		for (int i = 0; i < ITERATIONS; i++) {
			sum += app.subexpression();
		}
		System.out.println(sum);
	}

}
