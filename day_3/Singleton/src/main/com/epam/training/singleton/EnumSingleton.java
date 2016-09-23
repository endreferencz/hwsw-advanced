package com.epam.training.singleton;

public enum EnumSingleton {

	INSTANCE;

	EnumSingleton() {
		System.out.println("EnumSingleton()");
	}

	public void foo() {

	}

	public static void sfoo() {

	}

}
