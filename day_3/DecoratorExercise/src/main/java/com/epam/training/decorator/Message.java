package com.epam.training.decorator;

import java.util.Date;

public class Message {

	private String sender;

	private Date timestamp;

	private String message;

	public Message(String sender, Date timestamp, String message) {
		super();
		if (sender == null) {
			throw new IllegalArgumentException("Sender cannot be null");
		}
		if (timestamp == null) {
			throw new IllegalArgumentException("Timestamp cannot be null");
		}
		if (message == null) {
			throw new IllegalArgumentException("Message cannot be null");
		}
		this.sender = sender;
		this.timestamp = timestamp;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", timestamp=" + timestamp + ", message=" + message + "]";
	}

}
