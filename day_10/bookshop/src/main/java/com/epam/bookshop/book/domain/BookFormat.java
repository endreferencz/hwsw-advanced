package com.epam.bookshop.book.domain;

public enum BookFormat {
	ELECTRONIC("Electronic"), HARD_COVER("Hard cover"), SOFT_COVER("Soft cover");

	private String displayName;

	private BookFormat(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static BookFormat getByName(String name) {
		BookFormat result = null;
		for (int i = 0; i < values().length && result == null; i++) {
			BookFormat current = values()[i];
			if (current.name().equals(name)) {
				result = current;
			}
		}
		if (result == null) {
			throw new IllegalArgumentException("Invalid BookFormat name: " + name);
		}
		return result;
	}
}
