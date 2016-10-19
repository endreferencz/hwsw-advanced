package com.epam.bookshop.home.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.bookshop.authentication.service.AuthenticationService;
import com.epam.bookshop.authentication.view.controller.LoginFormController;
import com.epam.bookshop.home.view.model.HomepageModel;
import com.epam.bookshop.home.view.model.LanguageUrlMapping;
import com.epam.bookshop.home.view.support.LocalizationUrlBuilder;
import com.epam.bookshop.i18n.service.LocalizationService;
import com.epam.bookshop.stock.view.controller.AddBookFormController;

@Controller
public class HomeController {
	public static final String REQUEST_MAPPING = "/";
	private LocalizationService localizationService;
	private AuthenticationService authenticationService;
	private LocalizationUrlBuilder localizationUrlBuilder;

	@Autowired
	public HomeController(LocalizationService localizationService, AuthenticationService authenticationService, LocalizationUrlBuilder localizationUrlBuilder) {
		super();
		this.localizationService = localizationService;
		this.authenticationService = authenticationService;
		this.localizationUrlBuilder = localizationUrlBuilder;
	}

	@ModelAttribute("homepageModel")
	public HomepageModel homepageModel() {
		HomepageModel result = new HomepageModel();
		result.setBookshopName("Bookshop");
		result.setLanguageSelectors(getLanguageSelectors());
		if (authenticationService.isUserAuthenticated()) {
			result.setLogoutUrl("/j_spring_security_logout");
			if (authenticationService.isUserAdmin()) {
				result.setAdminUrl(AddBookFormController.REQUEST_MAPPING);
			}
		} else {
			result.setLoginUrl(LoginFormController.REQUEST_MAPPING);
		}
		return result;
	}

	private List<LanguageUrlMapping> getLanguageSelectors() {
		return localizationUrlBuilder.buildAccessibleLanguageSelectors(localizationService.getAccessibleLanguages());
	}

	@RequestMapping(REQUEST_MAPPING)
	public String homepage() {
		return "homepage";
	}
}
