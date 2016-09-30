package com.epam.training.decorator;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		Chat chat = new LoggerDecorator(new FilterDecorator(new ReplyChat()));
		chat.send(new Message("Sender", new Date(), "java"));
		Message message = chat.receive(1, TimeUnit.SECONDS);
		System.out.println(message);
	}

}
