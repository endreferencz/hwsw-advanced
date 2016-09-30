package com.epam.training.decorator;

import java.util.concurrent.TimeUnit;

public class LoggerDecorator implements Chat {

	private Chat chat;

	public LoggerDecorator(Chat chat) {
		this.chat = chat;
	}

	@Override
	public void send(Message message) {
		System.out.println(message);
		chat.send(message);
	}

	@Override
	public Message receive(long timeout, TimeUnit unit) throws InterruptedException {
		Message message = chat.receive(timeout, unit);
		return message;
	}

}
