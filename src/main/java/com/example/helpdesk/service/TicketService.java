package com.example.helpdesk.service;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.storage.StaffStorage;
import com.example.helpdesk.storage.TicketStorage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketService {

    /**
     * Pola z pracownikami i ticketami
     */
    private final StaffStorage staffStorage;
    private final TicketStorage ticketStorage;

    public TicketService(StaffStorage staffStorage, TicketStorage ticketStorage) {
        this.staffStorage = staffStorage;
        this.ticketStorage = ticketStorage;
    }

    /**
     * Prosta metoda ktora zwraca sie do Storage w celu dodania nowego ticketu
     * @param id
     * @param status
     * @param nameTicket
     * @param person
     * @param staffName
     * @return
     */
    public Ticket addNew(String id, Status status, String nameTicket, Person person, String staffName) {
        return ticketStorage.addNewTicket(new Ticket(id, status, nameTicket, person, staffStorage.findBySurname(staffName)));
    }

    /**
     * Tutaj tak samo, zwracamy sie do Storage w celu znalezienia ticketu po ID i wyswietleniem go w konsoli
     * @param id
     * @return
     */
    public List<Ticket> printTicketById(String id) {
        return ticketStorage.findById(id);
    }

    /**
     * Update po statusie
     * Wyciagamy ze storage wszystkie tickety
     * Nastepnie korzystamy ze stream i filtrujemy je wszsytkie w celu znalezienia ticketu o podanym ID
     * jak juz znajdziemy to mapujemy czyli zmieniamy dany status na taki jaki nas interesuje
     * po czym zapisujemy do listy
     * @param id
     * @param status
     * @return
     */
    public List<Ticket> updateStatusTicket(String id, Status status) {
        List<Ticket> allTicket = ticketStorage.getAllTicket();

        System.out.println("TICKET BEFORE UPDATE STATUS");
        System.out.println("===========================");
        System.out.println(allTicket.stream().filter(ticketId -> ticketId.getId().equals(id)).findFirst());
        System.out.println();

        System.out.println("TICKET AFTER UPDATE STATUS");
        System.out.println("==========================");
        return allTicket.stream().filter(ticketId->ticketId.getId().equals(id)).findFirst().map(t -> {
            t.setStatus(status);
            return t;
        }).stream().collect(Collectors.toList());

    }

    /**
     * Tak samo jak wyżej tylko zmieniamy pracownika w danym tickecie
     * @param id
     * @param staff
     * @return
     */
    public List<Ticket> updateStaffTicket(String id, String staff) {
        List<Ticket> allTicket = ticketStorage.getAllTicket();

        System.out.println("TICKET BEFORE UPDATE STAFF");
        System.out.println("===========================");
        System.out.println(allTicket.stream().filter(ticketId -> ticketId.getId().equals(id)).findFirst());
        System.out.println();

        System.out.println("TICKET AFTER UPDATE STAFF");
        System.out.println("=========================");
        return allTicket.stream().filter(i->i.getId().equals(id)).findFirst().map(t -> {
            t.setStaff(staffStorage.findBySurname(staff));
            return t;
        }).stream().collect(Collectors.toList());

    }

    /**
     * Tutaj nie wiem czy tego wymagał prowadzący ale metoda usuwajaca z listy ticket o podanym id
     * @param id
     * @return
     */
    public List<Ticket> deleteTicketById(String id) {
        // Ticekt do usuniecia o danym ID
        List<Ticket> ticketToRemove = ticketStorage.findById(id).stream().toList();
        System.out.println("THIS TICKET WILL BE REMOVED FROM TICKET STORAGE.");
        System.out.println("================================================");
        System.out.println(ticketToRemove);
        System.out.println();

        List<Ticket> allTicket = ticketStorage.getAllTicket();
        System.out.println("TICKET STORAGE BEFORE REMOVE TICKET");
        System.out.println("===================================");
        System.out.println(allTicket);
        System.out.println();

        // Usuwamy ticket który wcześniej znaleźlismy
        // Jezeli lista allTicket zawiera liste a w tym przypadku liste skladajaca sie z jednego elementu o podanym ID to usun z tej listy ten wlasnie element
        allTicket.removeIf(x->ticketToRemove.contains(x));
        System.out.println("TICKET STORAGE AFTER REMOVE TICKET");
        System.out.println("==================================");

        return allTicket;
    }

}
