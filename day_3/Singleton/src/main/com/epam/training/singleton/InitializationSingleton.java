package com.epam.training.singleton;

public class InitializationSingleton {

	private static final InitializationSingleton INSTANCE = new InitializationSingleton();

	private InitializationSingleton() {
		System.out.println("InitializationSingleton()");
	}

	public static InitializationSingleton getInstance() {
		return INSTANCE;
	}

	public static void sfoo() {

	}

}
