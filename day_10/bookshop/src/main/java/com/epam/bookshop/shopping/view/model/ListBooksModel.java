package com.epam.bookshop.shopping.view.model;

import java.util.List;

public class ListBooksModel {
	private List<BookSummaryView> books;

	public ListBooksModel(List<BookSummaryView> books) {
		super();
		this.books = books;
	}

	public List<BookSummaryView> getBooks() {
		return books;
	}

}
