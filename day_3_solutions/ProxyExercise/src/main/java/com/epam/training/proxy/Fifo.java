package com.epam.training.proxy;

public interface Fifo<T> {

	void put(T element);
	
	T pop();
}
