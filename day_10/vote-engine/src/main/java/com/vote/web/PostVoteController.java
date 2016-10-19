package com.vote.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vote.service.VoteService;

@Controller
@SessionAttributes("voted")
public class PostVoteController {

    @Autowired
    private VoteService voteService;
    
    @ModelAttribute("voted")
    public boolean voted() {
        return false;
    }

    @RequestMapping(value = "/vote", method = RequestMethod.POST)
    public String vote(@RequestParam("name") String name, @SessionAttribute("voted") boolean voted, Model model, HttpServletRequest request) {
        if (!voted) {
            voteService.vote(name, request.getRemoteAddr());
        }
        System.out.println(voteService.getResults());
        model.addAttribute("voted", true);
        return "redirect:results";
    }
    
    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public String voteOptions(Model model) {
        model.addAttribute("results", voteService.getResults());
        return "vote";
    }

}
