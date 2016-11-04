package com.epam.training.javasecurity.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/forward")
public class ForwardController {

	@RequestMapping(method=RequestMethod.GET)
	public String forward(@RequestParam String page, HttpServletRequest request) {
		return "redirect:" + page;
	}

}