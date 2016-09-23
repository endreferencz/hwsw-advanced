package com.epam.training.proxy;

import java.util.ArrayList;

import com.epam.training.proxy.Fifo;

public class FifoUsingLotsOfMemory<T> implements Fifo<T> {

	private ArrayList<T> list = new ArrayList<T>(1000);

	public FifoUsingLotsOfMemory() {
	}

	@Override
	public void put(T element) {
		list.add(element);
	}

	@Override
	public T pop() {
		if (list.isEmpty()) {
			throw new IndexOutOfBoundsException("No more elements");
		} else {
			return list.remove(0);
		}
	}
}
