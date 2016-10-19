package com.epam.bookshop.book.domain;

public class Book {

	private Long bookId;
	private String title;
	private String author;
	private String synopsis;
	private BookFormat format;
	private byte[] cover;

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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public BookFormat getFormat() {
		return format;
	}

	public void setFormat(BookFormat format) {
		this.format = format;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

}
