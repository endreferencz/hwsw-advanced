package com.epam.bookshop.stock.view.model;

import java.util.List;

import com.epam.bookshop.book.domain.BookFormat;

public class AddBookFormModel {
	private List<BookFormat> availableBookFormats;

	public AddBookFormModel(List<BookFormat> availableBookFormats) {
		super();
		this.availableBookFormats = availableBookFormats;
	}

	public List<BookFormat> getAvailableBookFormats() {
		return availableBookFormats;
	}

}
