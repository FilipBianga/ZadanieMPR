package com.example.helpdesk.model;

public class Person {
    private String firstname;
    private String surname;
    private String email;
    private int number;

    public String getSurname() {
        return surname;
    }

    public Person(String firstname, String surname, String email, int number) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.number = number;
    }

    @Override
    public String toString() {
        return "{"  + firstname +
                " " + surname +
                ", email='" + email + '\'' +
                ", telefon='" + number + '\'' +
                '}';
    }
}
