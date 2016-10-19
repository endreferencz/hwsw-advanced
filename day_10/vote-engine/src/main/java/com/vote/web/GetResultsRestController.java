package com.vote.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vote.repository.VoteResult;
import com.vote.service.VoteService;

@RestController
public class GetResultsRestController {

    @Autowired
    private VoteService voteService;

    @RequestMapping("/api/results")
    public VoteResult getResults() {
        return voteService.getResults();
    }

}
