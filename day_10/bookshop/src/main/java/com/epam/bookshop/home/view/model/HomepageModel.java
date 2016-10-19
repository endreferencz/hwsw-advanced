package com.epam.bookshop.home.view.model;

import java.util.List;

public class HomepageModel {
	private String bookshopName;
	private List<LanguageUrlMapping> languageSelectors;
	private String loginUrl;
	private String logoutUrl;
	private String adminUrl;

	public String getBookshopName() {
		return bookshopName;
	}

	public void setBookshopName(String bookshopName) {
		this.bookshopName = bookshopName;
	}

	public List<LanguageUrlMapping> getLanguageSelectors() {
		return languageSelectors;
	}

	public void setLanguageSelectors(List<LanguageUrlMapping> languageSelectors) {
		this.languageSelectors = languageSelectors;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getAdminUrl() {
		return adminUrl;
	}

	public void setAdminUrl(String adminUrl) {
		this.adminUrl = adminUrl;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

}
