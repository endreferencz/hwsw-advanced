package com.vote.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vote.repository.VoteResult;
import com.vote.service.VoteService;

@Controller
public class VoteResultController {

    @Autowired
    private VoteService voteService;

    @ModelAttribute("results")
    public VoteResult results() {
        return voteService.getResults();
    }

    @RequestMapping("/results")
    public String showResults() {
        return "results";
    }

}
