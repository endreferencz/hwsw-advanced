package com.epam.telephone;

public class Person {

    private String name;

    private TelephoneNumber number;

    public Person(String name, TelephoneNumber number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TelephoneNumber getNumber() {
        return number;
    }

    public void setNumber(TelephoneNumber number) {
        this.number = number;
    }

}
