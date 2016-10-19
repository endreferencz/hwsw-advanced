package com.vote.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public ModelAndView welcome(@RequestParam(value = "name", required = false) String name) {
        return new ModelAndView("hello", "name", name);
    }

}
