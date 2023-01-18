package com.example.helpdesk.service;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Staff;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.storage.PersonStorage;
import com.example.helpdesk.storage.StaffStorage;
import com.example.helpdesk.storage.TicketStorage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TicketService {

    private final PersonStorage personStorage;
    private final StaffStorage staffStorage;
    private final TicketStorage ticketStorage;

    public TicketService(PersonStorage personStorage, StaffStorage staffStorage, TicketStorage ticketStorage) {
        this.personStorage = personStorage;
        this.staffStorage = staffStorage;
        this.ticketStorage = ticketStorage;
    }

    public Ticket addNew(String id, Status status, String nameTicket, Person person, String staffName) {

        Optional<Staff> staff = Optional.ofNullable(staffStorage.findBySurname(staffName));

        if(staff.isEmpty()){
            System.out.println("Nie ma staffu");
            return null;
        }

        Ticket newTicket = ticketStorage.addNewTicket(new Ticket(id, status, nameTicket, person, staffStorage.findBySurname(staffName)));



        return newTicket;
    }

    public List<Ticket> deleteById(String id) {
        List<Ticket> ticketToRemove = ticketStorage.findById(id).stream().toList();
        return ticketToRemove;
    }


}
