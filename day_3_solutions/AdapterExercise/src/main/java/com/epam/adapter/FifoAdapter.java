package com.epam.adapter;

import java.util.ArrayList;

public class FifoAdapter<T> implements Fifo<T> {
	
	private ArrayList<T> list = new ArrayList<>();

	@Override
	public void push(T t) {
		list.add(t);
	}

	@Override
	public T pop() {
		return list.remove(0);
	}

}
