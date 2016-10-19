package com.vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vote.repository.Vote;
import com.vote.repository.VoteRepository;
import com.vote.repository.VoteResult;

@Component
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;
    
    public VoteResult getResults() {
        Iterable<Vote> votes = voteRepository.findAll();
        VoteResult voteResult = new VoteResult();
        for (Vote vote : votes) {
            voteResult.vote(vote.getName());
        }
        return voteResult;
    }

    public void vote(String name, String ip) {
        voteRepository.save(new Vote(name, ip));
    }
    
}
