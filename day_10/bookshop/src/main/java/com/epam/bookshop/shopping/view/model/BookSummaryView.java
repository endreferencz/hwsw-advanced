package com.epam.bookshop.shopping.view.model;


public class BookSummaryView {
	private Long bookId;
	private String title;
	private String author;
	private String detailsUrl;
	private String bookFormat;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDetailsUrl() {
		return detailsUrl;
	}

	public void setDetailsUrl(String detailsUrl) {
		this.detailsUrl = detailsUrl;
	}

	public String getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(String bookFormat) {
		this.bookFormat = bookFormat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookFormat == null) ? 0 : bookFormat.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((detailsUrl == null) ? 0 : detailsUrl.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BookSummaryView other = (BookSummaryView) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookFormat == null) {
			if (other.bookFormat != null)
				return false;
		} else if (!bookFormat.equals(other.bookFormat))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (detailsUrl == null) {
			if (other.detailsUrl != null)
				return false;
		} else if (!detailsUrl.equals(other.detailsUrl))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
