package com.example.helpdesk.storage;

import com.example.helpdesk.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonStorage {
    private final List<Person> personList = new ArrayList<>();

    public PersonStorage() {
        personList.add(new Person("Jan", "Kowal", "jankowal@example.com", 777888222));
        personList.add(new Person("Adam", "Nowak", "adamnowak@example.com", 799000888));
    }

    public Person findBySurname(String name) {
        return personList.
                stream().
                filter(storage -> storage.getSurname().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
