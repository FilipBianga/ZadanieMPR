package com.example.helpdesk.storage;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Staff;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class TicketStorage {

    private final List<Ticket> ticketList = new ArrayList<>();

    public TicketStorage() {
        ticketList.add(new Ticket("1", Status.NEW, "Second ticket", new Person("Jan", "Kowalski", "jankowalski@example.com", 789988888), new Staff("Witold", "Zly", "wzly@staff.pl")));
    }

    public List<Ticket> getAllTicket() {
        return ticketList;
    }

    public List<Ticket> findById(String id) {
        return ticketList.stream().filter(i->i.getId().equals(id)).findFirst().stream().toList();
    }

    public Ticket addNewTicket(Ticket ticket) {
        ticketList.add(ticket);

        return ticket;
    }





}
