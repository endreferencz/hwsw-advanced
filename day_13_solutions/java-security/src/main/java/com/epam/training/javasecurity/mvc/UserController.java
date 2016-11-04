package com.epam.training.javasecurity.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.javasecurity.data.User;
import com.epam.training.javasecurity.data.UserRepository;

@Controller
@RequestMapping("/admin/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView list() {
    	Iterable<User> users = userRepository.findAll();
        return new ModelAndView("admin/users", "users", users);
    }

}
