package com.epam.training.decorator;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ReplyChat implements Chat {

	private BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();

	@Override
	public void send(Message message) {
		queue.add(message);
	}

	@Override
	public Message receive(long timeout, TimeUnit unit) throws InterruptedException {
		return queue.poll(timeout, unit);
	}
	
}
