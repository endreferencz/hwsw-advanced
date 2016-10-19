package com.epam.bookshop.home.view.model;

public class LanguageUrlMapping {
	private String languageCode;
	private String languageSelectorUrl;

	public LanguageUrlMapping(String languageCode, String languageSelectorUrl) {
		super();
		this.languageCode = languageCode;
		this.languageSelectorUrl = languageSelectorUrl;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageSelectorUrl() {
		return languageSelectorUrl;
	}

	public void setLanguageSelectorUrl(String languageSelectorUrl) {
		this.languageSelectorUrl = languageSelectorUrl;
	}

}
