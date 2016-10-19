package com.epam.bookshop.i18n.service;

public enum LanguageCode {
	HU("hu_HU"), EN("en_US");
	private String code;

	private LanguageCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
