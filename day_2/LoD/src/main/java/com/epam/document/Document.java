package com.epam.document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Document {

	private final List<Paragraph> paragraphs;

	public Document(final List<Paragraph> paragraphs) {
		List<Paragraph> copyList = new ArrayList<Paragraph>();
		copyList.addAll(paragraphs);
		this.paragraphs = copyList;
	}

	public Iterable<Paragraph> getParagraphs() {
		return Collections.unmodifiableCollection(paragraphs);
	}

}
