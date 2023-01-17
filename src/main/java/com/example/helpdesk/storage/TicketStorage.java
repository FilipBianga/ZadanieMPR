package com.example.helpdesk.storage;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Staff;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TicketStorage {

    private final List<Ticket> ticketList = new ArrayList<>();

    public TicketStorage() {
        ticketList.add(new Ticket(1, Status.NEW, "Second ticket", new Person("Jan", "Kowalski", "jankowalski@example.com", 789988888), new Staff("WItold", "Zly", "wzly@staff.pl")));
    }

    public List<Ticket> getALlTicket() {
        return ticketList;
    }

    public Ticket addNewTicket(Ticket ticket) {
        ticketList.add(ticket);

        return ticket;
    }




}
