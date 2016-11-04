package com.epam.training.javasecurity.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.javasecurity.security.CurrentUser;
import com.epam.training.javasecurity.security.CustomUserDetails;

@Controller
public class AccessDeniedController {
	@RequestMapping("/access-denied")
	public ModelAndView accessDenied(@CurrentUser CustomUserDetails currentUser) {
		ModelAndView model = new ModelAndView();
		if (currentUser != null) {
			model.addObject("msg", "Hi " + currentUser.getFirstName() + " " + currentUser.getLastName()
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
			"You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
}
