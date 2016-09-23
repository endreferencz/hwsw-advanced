package com.epam.training.singleton;

public class StaticInitializerSingleton {
	private static final StaticInitializerSingleton INSTANCE;

	static {
		INSTANCE = new StaticInitializerSingleton();
	}

	private StaticInitializerSingleton() {
		System.out.println("StaticInitializerSingleton()");
	}

	public static StaticInitializerSingleton getInstance() {
		return INSTANCE;
	}

	public static void sfoo() {

	}
}
