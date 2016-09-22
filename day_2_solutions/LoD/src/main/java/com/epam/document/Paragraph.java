package com.epam.document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Paragraph {

	private final List<Line> lines;

	public Paragraph(final Collection<Line> lines) {
		List<Line> copyList = new ArrayList<Line>();
		copyList.addAll(lines);
		this.lines = copyList;
	}

	public void print() {
		for (Line line : lines) {
			line.print();
		}
		System.out.println();
	}

}
