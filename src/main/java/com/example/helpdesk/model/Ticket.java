package com.example.helpdesk.model;

public class Ticket {
    private final String id;
    private final Status status;
    private final String nameTicket;
    private final Person person;
    private final Staff staff;

    public Ticket(String id, Status status, String nameTicket, Person person, Staff staff) {
        this.id = id;
        this.status = status;
        this.nameTicket = nameTicket;
        this.person = person;
        this.staff = staff;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", ticket name='" + nameTicket + '\'' +
                ", person='" + person + '\'' +
                ", staff='" + staff + '\'' +
                '}';
    }
}
