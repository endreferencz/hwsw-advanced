package com.epam.training.proxy;

public class FifoProxy<T> implements Fifo<T> {

	private Fifo<T> fifo;

	@Override
	public void put(T element) {
		ensureExists();
		fifo.put(element);
	}

	@Override
	public T pop() {
		ensureExists();
		return fifo.pop();
	}

	private void ensureExists() {
		if (fifo == null) {
			fifo = new FifoUsingLotsOfMemory<>();
		}
	}

}
