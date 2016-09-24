package com.epam.telephone;

public class Application {

    public static void main(String[] args) {
        Person person = createPerson();
        call(person);
    }

    private static void call(Person person) {
        person.getNumber().call();
    }

    private static Person createPerson() {
        Person person = new Person("John", new TelephoneNumber());
        return person;
    }

}
