package com.example.helpdesk.storage;

import com.example.helpdesk.model.Staff;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaffStorage {

    /**
     * TUtaj opisywać nie będę bo ma się to tak jak w TicketStorage
     */
    private final List<Staff> staffList = new ArrayList<>();

    public StaffStorage() {
        staffList.add(new Staff("Zbigniew", "Podwlazly", "zpod@helpdesk.pl"));
        staffList.add(new Staff("Marian", "Nizy", "m.nizy@helpdesk.pl"));
        staffList.add(new Staff("Michał", "Wiśniewski", "mwis@helpdesk.pl"));
        staffList.add(new Staff("Kamil", "Wójcik", "kwojcik@helpdesk.pl"));
        staffList.add(new Staff("Filip", "Kowalczyk", "f.kowalczyk@helpdesk.pl"));
    }

    /**
     * Metoda wyszukująca pracownika po podanym nazwisku
     * @param name
     * @return dany element z listy o podanym nazwisku
     */
    public Staff findBySurname(String name) {
        return staffList.
                stream()
                .filter(storage -> storage.getSurname().equals(name))
                .findFirst()
                .orElseThrow();
    }

}
