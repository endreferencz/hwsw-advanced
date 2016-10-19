package com.vote.repository;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class VoteResult implements Iterable<Map.Entry<String, Long>> {

    @XmlElement
    @JsonProperty
    private Map<String, Long> votes = new ConcurrentHashMap<>();

    public VoteResult() {
        register("A");
        register("B");
        register("C");
        register("D");
    }

    public void register(String name) {
        votes.put(name, 0L);
    }

    public void vote(String name) {
        long numberOfVotes = getNumberOfVotes(name);
        votes.put(name, numberOfVotes + 1);
    }

    private long getNumberOfVotes(String name) {
        Long numberOfVotes = votes.get(name);
        if (numberOfVotes == null) {
            numberOfVotes = 0L;
        }
        return numberOfVotes;
    }

    @Override
    public Iterator<Entry<String, Long>> iterator() {
        return votes.entrySet().iterator();
    }

    @Override
    public String toString() {
        return "VoteResult [votes=" + votes + "]";
    }

}
