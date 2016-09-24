package com.epam.document;

public class Application {

	private void start() {
		Document document = new DocumentCreator().createDocument();
		printDocument(document);
	}

	private void printDocument(Document document) {
		document.print();
	}

	public static void main(String[] args) {
		new Application().start();
	}

}
