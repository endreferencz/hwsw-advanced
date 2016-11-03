package com.epam.training.javasecurity.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epam.training.javasecurity.data.User;
import com.epam.training.javasecurity.data.UserRepository;

@Controller
public class LoginController {
	UserRepository userDao;
	
	@Autowired
	public LoginController(com.epam.training.javasecurity.data.UserRepository userDao) {
		super();
		this.userDao = userDao;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirect,
			HttpSession session, HttpServletRequest request) {
		session.removeAttribute("currentUser");
		User currentUser = userDao.findByEmailAndPassword(username, password);
		if (currentUser != null) {			
			session.setAttribute("currentUser", currentUser);
			return "redirect:/";
		}
		else {
			redirect.addFlashAttribute("globalMessage", "Unknown user or wrong password.");
			return "redirect:/login";
		}
	
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, RedirectAttributes redirect) {
		session.removeAttribute("currentUser");
		redirect.addFlashAttribute("currentUser", "Successfully logged out.");
		return "redirect:/login";
	}
	
}
