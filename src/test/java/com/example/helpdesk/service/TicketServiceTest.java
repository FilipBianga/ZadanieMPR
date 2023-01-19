package com.example.helpdesk.service;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.storage.StaffStorage;
import com.example.helpdesk.storage.TicketStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketServiceTest {

    private TicketService service;

    @BeforeEach
    void setUp() {
        StaffStorage staffStorage = new StaffStorage();
        TicketStorage ticketStorage = new TicketStorage(staffStorage);
        service = new TicketService(staffStorage, ticketStorage);
    }

    @Test
    void successAddTicket() {
        //when
        Ticket ticket = service.addNew(
                "14",
                Status.NEW,
                "Najnowszy Ticket TESTOWY",
                new Person("Jan", "Nowak", "jan.nowak@example.com", 987018976),
                "Kowalczyk"
        );

        //then
        assertThat(ticket).isNotNull();
        assertThat(ticket).hasToString("Ticket {id='14', status='NEW', ticket name='Najnowszy Ticket TESTOWY', person='{Jan Nowak, email='jan.nowak@example.com', telefon='987018976'}', staff='{Filip Kowalczyk, email='f.kowalczyk@helpdesk.pl'}'}");
    }

    @Test
    void ticketByIdDoesntExist() {
        //when
        List<Ticket> ticketId = service.printTicketById("15");

        //then
        assertTrue(ticketId.isEmpty());
    }

    @Test
    void successUpdateStatus() {
        //when
        Ticket ticket = service.addNew(
                "14",
                Status.NEW,
                "Najnowszy Ticket TESTOWY",
                new Person("Jan", "Nowak", "jan.nowak@example.com", 987018976),
                "Kowalczyk"
        );
        service.updateStatusTicket("14", Status.DONE);

        //then
        assertThat(ticket).hasToString("Ticket {id='14', status='DONE', ticket name='Najnowszy Ticket TESTOWY', person='{Jan Nowak, email='jan.nowak@example.com', telefon='987018976'}', staff='{Filip Kowalczyk, email='f.kowalczyk@helpdesk.pl'}'}");
    }

    @Test
    void successUpdateStaff() {
        //when
        Ticket ticket = service.addNew(
                "14",
                Status.NEW,
                "Najnowszy Ticket TESTOWY",
                new Person("Jan", "Nowak", "jan.nowak@example.com", 987018976),
                "Kowalczyk"
        );
        service.updateStaffTicket("14", "Wójcik");

        //then
        assertThat(ticket).hasToString("Ticket {id='14', status='NEW', ticket name='Najnowszy Ticket TESTOWY', person='{Jan Nowak, email='jan.nowak@example.com', telefon='987018976'}', staff='{Kamil Wójcik, email='kwojcik@helpdesk.pl'}'}");
    }


}