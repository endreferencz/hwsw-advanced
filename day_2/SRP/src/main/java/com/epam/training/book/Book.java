package com.epam.training.book;

public class Book {

	private String authorName;

	private String authorDescription;

	private int yearOfPublication;

	private String title;

	private String description;
	
	public Book() {
		super();
	}

	public void setAuthor(String name, String description) {
		this.authorName = name;
		this.authorDescription = description;
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
		return authorName;
	}

	public String getAuthorDescription() {
		return authorDescription;
	}

	@Override
	public String toString() {
		return "Book [authorName=" + authorName + ", authorDescription="
				+ authorDescription + ", yearOfPublication="
				+ yearOfPublication + ", title=" + title + ", description="
				+ description + "]";
	}

}
