package com.epam.document;

public class Application {

	private void start() {
		Document document = new DocumentCreator().createDocument();
		printDocument(document);
	}

	private void printDocument(Document document) {
		for (Paragraph paragraph : document.getParagraphs()) {
			for (Line line : paragraph.getLines()) {
				System.out.println(line.getContent());
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Application().start();
	}

}
