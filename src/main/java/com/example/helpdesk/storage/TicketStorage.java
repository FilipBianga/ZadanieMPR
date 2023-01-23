package com.example.helpdesk.storage;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class TicketStorage {

    private final List<Ticket> ticketList = new ArrayList<>();

    private final StaffStorage staffStorage;

    public TicketStorage(StaffStorage staffStorage) {
        this.staffStorage = staffStorage;
        ticketList.add(new Ticket("1", Status.NEW, "Ticket Name 1", new Person("Jan", "Kowalski", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Nizy")));
        ticketList.add(new Ticket("2", Status.NEW, "Ticket Name 2", new Person("Julia", "Szymańska", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Wójcik")));
        ticketList.add(new Ticket("3", Status.NEW, "Ticket Name 3", new Person("Mateusz", "Kamiński", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Wiśniewski")));
        ticketList.add(new Ticket("4", Status.NEW, "Ticket Name 4", new Person("Kacper", "Woźniak", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Wójcik")));
        ticketList.add(new Ticket("5", Status.NEW, "Ticket Name 5", new Person("Anna", "Zielińska", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Kowalczyk")));
    }

    public List<Ticket> getAllTicket() {
        return ticketList;
    }

    public Ticket addNewTicket(Ticket ticket) {
        ticketList.add(ticket);

        return ticket;
    }

    public List<Ticket> findById(String id) {
        return ticketList.stream().filter(i->i.getId().equals(id)).findFirst().stream().toList();
    }


}
