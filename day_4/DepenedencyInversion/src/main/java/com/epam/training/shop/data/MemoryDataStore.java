package com.epam.training.shop.data;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryDataStore<T> {

	private ArrayList<T> store = new ArrayList<T>();

	public void add(T t) {
		store.add(t);
	}

	public Iterable<T> list() {
		return Collections.unmodifiableCollection(store);
	}

}
