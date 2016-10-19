package com.epam.bookshop.shopping.view.model;

public class BookShoppingCartItem {
	private BookSummaryView book;
	private Integer quantity;

	public BookShoppingCartItem(BookSummaryView book, Integer quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}

	public BookSummaryView getBook() {
		return book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Long getBookId() {
		return book.getBookId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookShoppingCartItem other = (BookShoppingCartItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	
	
}
