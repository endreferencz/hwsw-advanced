package com.epam.observer;

public class HelloObserver implements Observer {

	@Override
	public void event(Counter counter) {
		 System.out.println("counter=" + counter + ", time= " + System.currentTimeMillis() + ", id = " + this);
	}

}
