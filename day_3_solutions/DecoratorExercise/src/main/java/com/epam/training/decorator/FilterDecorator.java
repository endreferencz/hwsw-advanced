package com.epam.training.decorator;

import java.util.concurrent.TimeUnit;

public class FilterDecorator implements Chat {

	private Chat chat;

	public FilterDecorator(Chat chat) {
		this.chat = chat;
	}

	@Override
	public void send(Message message) {
		if (!message.getMessage().contains("java")) {
			chat.send(message);
		}
	}

	@Override
	public Message receive(long timeout, TimeUnit unit) throws InterruptedException {
		return chat.receive(timeout, unit);
	}

}
