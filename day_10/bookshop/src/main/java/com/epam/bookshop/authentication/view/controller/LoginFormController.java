package com.epam.bookshop.authentication.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.bookshop.authentication.view.model.LoginRequest;

@Controller
public class LoginFormController {
	public static final String REQUEST_MAPPING = "/login.html";

	@ModelAttribute("loginRequest")
	public LoginRequest createLoginRequest() {
		return new LoginRequest();
	}

	@RequestMapping(REQUEST_MAPPING)
	public String showLogin(@ModelAttribute("loginRequest") LoginRequest loginRequest, BindingResult bindingResult, HttpSession httpSession) {
		Throwable authException = (Throwable) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (authException != null) {
			bindingResult.reject(authException.getMessage(), authException.getMessage());
			httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		}
		return "login_form";
	}
}
