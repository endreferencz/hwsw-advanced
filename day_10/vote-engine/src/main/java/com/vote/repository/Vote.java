package com.vote.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String ip;

    public Vote() {
    }

    public Vote(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

}
