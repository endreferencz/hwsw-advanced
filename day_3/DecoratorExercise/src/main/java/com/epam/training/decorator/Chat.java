package com.epam.training.decorator;

import java.util.concurrent.TimeUnit;

public interface Chat {

	void send(Message message);

	Message receive(long timeout, TimeUnit unit) throws InterruptedException;
	
}
