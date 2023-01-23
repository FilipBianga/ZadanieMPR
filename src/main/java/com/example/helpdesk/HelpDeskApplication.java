package com.example.helpdesk;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.service.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpDeskApplication {

    public HelpDeskApplication(TicketService service) {
        Ticket ticket = service.addNew(
                "6",
                Status.NEW,
                "Najnowszy Ticket",
                new Person("Filip", "Nowakowski", "fnowakowski@example.com", 987098976),
                "Kowalczyk"
        );
        System.out.println("NEW TICKET");
        System.out.println(ticket);
        System.out.println();
        System.out.println("PRINT TICKET BY ID");
        System.out.println(service.printTicketById("5"));
        System.out.println();
        System.out.println("UPDATE STATUS");
        System.out.println(service.updateStatusTicket("1", Status.IN_PROGRESS));
        System.out.println();
        System.out.println("UPDATE STAFF");
        System.out.println(service.updateStaffTicket("1", "Wójcik"));
        System.out.println();
        System.out.println("DELETE BY ID");
        System.out.println(service.deleteTicketById("1"));
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelpDeskApplication.class, args);

    }

}
