package com.example.zal;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PersonTableDbInMemory {

    List<Person> persons = new ArrayList<>();

    public Person add(Person person) {
        persons.add(person);
        return person;
    }

    List<Person> getPersons() {
        return persons;
    }

}
