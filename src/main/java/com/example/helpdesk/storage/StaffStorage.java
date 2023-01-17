package com.example.helpdesk.storage;

import com.example.helpdesk.model.Staff;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StaffStorage {

    private final List<Staff> staffList = new ArrayList<>();

    public StaffStorage() {
        staffList.add(new Staff("Zbigniew", "Podwlazly", "zpod@helpdesk.pl"));
        staffList.add(new Staff("Marian", "Nizy", "m.nizy@helpdesk.pl"));
    }

    public Staff findBySurname(String name) {
        return staffList.
                stream()
                .filter(storage -> storage.getSurname().equals(name))
                .findFirst()
                .orElseThrow();
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

}
