package com.example.helpdesk;

import com.example.helpdesk.model.Person;
import com.example.helpdesk.model.Staff;
import com.example.helpdesk.model.Status;
import com.example.helpdesk.model.Ticket;
import com.example.helpdesk.service.TicketService;
import com.example.helpdesk.storage.StaffStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpDeskApplication {


    public HelpDeskApplication(TicketService service) {
        Ticket ticket = service.addNew(
                "2",
                Status.NEW,
                "Pierwszy lub drugi",
                new Person("Filip", "Nowakowski", "fnowakowski@example.com", 987098976),
                "Podwlazly"
        );

        System.out.println(ticket);
        System.out.println(service.deleteById("2"));


    }

    public static void main(String[] args) {
        SpringApplication.run(HelpDeskApplication.class, args);

    }

}
