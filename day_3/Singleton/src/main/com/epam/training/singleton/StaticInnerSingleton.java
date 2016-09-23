package com.epam.training.singleton;

public class StaticInnerSingleton {

	private StaticInnerSingleton() {
		System.out.println("StaticInnerSingleton()");
	}

	private static class Inner {
		private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
	}

	public static StaticInnerSingleton getInstance() {
		return Inner.INSTANCE;
	}

	public static void sfoo() {

	}
}
