package com.example.helpdesk.model;

public class Staff {
    private String firstname;
    private String surname;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public Staff(String firstname, String surname, String email) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "{"  + firstname +
                " " + surname +
                ", email='" + email + '\'' +
                '}';
    }
}
