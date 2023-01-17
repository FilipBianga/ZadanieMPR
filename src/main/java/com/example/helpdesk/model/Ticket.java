package com.example.helpdesk.model;

public class Ticket {
    private int id;
    private Status status;
    private String nameTicket;
    private Person person;
    private Staff staff;

    public Ticket(int id, Status status, String nameTicket, Person person, Staff staff) {
        this.id = id;
        this.status = status;
        this.nameTicket = nameTicket;
        this.person = person;
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", ticket name='" + nameTicket + '\'' +
                ", person='" + person + '\'' +
                ", staff='" + staff + '\'' +
                '}';
    }
}
