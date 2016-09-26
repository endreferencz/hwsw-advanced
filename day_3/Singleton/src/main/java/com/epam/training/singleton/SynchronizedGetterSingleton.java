package com.epam.training.singleton;

public class SynchronizedGetterSingleton {
	
	private static SynchronizedGetterSingleton INSTANCE;

	private SynchronizedGetterSingleton() {
		System.out.println("SynchronizedGetterSingleton()");
	}

	public static synchronized SynchronizedGetterSingleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SynchronizedGetterSingleton();
		}
		return INSTANCE;
	}

	public static void sfoo() {

	}
}
