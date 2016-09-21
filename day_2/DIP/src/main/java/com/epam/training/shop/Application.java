package com.epam.training.shop;

import com.epam.training.shop.store.Store;

public class Application {

	public void startDefault() {
		System.out.println("Default store: ");
		Store store = new Store();
		store.open();
		store.printPrices();
		System.out.println("Stock: " + store.stock());
	}

	public void startExclusive() {
		System.out.println("Exclusive store: ");
		Store store = new Store(true);
		store.open();
		store.printPrices();
		System.out.println("Stock: " + store.stock());
	}

	public static void main(String[] args) {
		new Application().startDefault();
		System.out.println();
		new Application().startExclusive();
	}
}
