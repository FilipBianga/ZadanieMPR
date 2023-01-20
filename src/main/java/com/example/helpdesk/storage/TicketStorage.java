package com.example.helpdesk.storage;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class TicketStorage {

    /**
     * W tej klasie przechowujemy nasze tickety i w niej mamy
     * 3 metody w których zwracamy sie do listy w celu wyszukania/dodania naszych ticketow
     */


    /**
     * Kolekcja List jest interfejsem i musimy ja zaimplementowac w tym przypadku ArrayLista
     */
    private final List<Ticket> ticketList = new ArrayList<>();

    /**
     * Pole z naszymi pracownikami
     */
    private final StaffStorage staffStorage;

    /**
     * Konstruktor z naszymi ticketami oraz przechowujemy naszych pracownikow
     * dopisujemy ich do ticketu poprzez metode wyszukania danego pracownika po Nazwisku
     * jezeli go nie bedzie wywali błąd
     * @param staffStorage
     */
    public TicketStorage(StaffStorage staffStorage) {
        this.staffStorage = staffStorage;
        ticketList.add(new Ticket("1", Status.NEW, "Ticket Name 1", new Person("Jan", "Kowalski", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Nizy")));
        ticketList.add(new Ticket("2", Status.NEW, "Ticket Name 2", new Person("Julia", "Szymańska", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Wójcik")));
        ticketList.add(new Ticket("3", Status.NEW, "Ticket Name 3", new Person("Mateusz", "Kamiński", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Wiśniewski")));
        ticketList.add(new Ticket("4", Status.NEW, "Ticket Name 4", new Person("Kacper", "Woźniak", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Wójcik")));
        ticketList.add(new Ticket("5", Status.NEW, "Ticket Name 5", new Person("Anna", "Zielińska", "jankowalski@example.com", 789988888), staffStorage.findBySurname("Kowalczyk")));
    }

    /**
     *Metoda wyświetlajaca wszystkie aktualne tickety w liscie
     * @return liste wszystkich ticketow
     */
    public List<Ticket> getAllTicket() {
        return ticketList;
    }

    /**
     * W tej metodzie dodajemy nasz ticket do naszej listy i zwracamy dodany ticket
     * @return nowy ticket
     */
    public Ticket addNewTicket(Ticket ticket) {
        ticketList.add(ticket);

        return ticket;
    }

    /**
     * Metoda majaca na celu wyszukać w naszej liście ticket o podanym w metodzie ID
     * Znajduje pierwszy i zapisuje do listy
     * @param id
     * @return
     */
    public List<Ticket> findById(String id) {
        return ticketList.stream().filter(i->i.getId().equals(id)).findFirst().stream().toList();
    }


}
