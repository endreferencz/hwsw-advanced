package com.epam.document;

public final class Line {

	private final String content;

	public Line(final String content) {
		this.content = content;
	}

	public void print() {
		System.out.println(content);
	}

}
