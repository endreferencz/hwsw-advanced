package com.epam.training.book;

public class Book {

	private Author author;

	private int yearOfPublication;

	private String title;

	private String description;
	
	public Book() {
		super();
	}

	public void setAuthor(String name, String description) {
		this.author = new Author(name, description);
	}

	public int getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorName() {
		return author.getName();
	}

	public String getAuthorDescription() {
		return author.getDescription();
	}

	@Override
	public String toString() {
		return "Book [authorName=" + author.getName() + ", authorDescription="
				+ author.getDescription() + ", yearOfPublication="
				+ yearOfPublication + ", title=" + title + ", description="
				+ description + "]";
	}

}
