package com.epam.observer;

public class StdOutObserver implements Observer {

	@Override
	public void event(Counter counter) {
		 System.out.println("hello");
	}

}
