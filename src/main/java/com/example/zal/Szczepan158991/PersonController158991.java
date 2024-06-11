package com.example.zal.Szczepan158991;


import com.example.zal.Person;
import com.example.zal.PersonTableDbInMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController158991 {

    private final PersonTableDbInMemory personTableDbInMemory;

    public PersonController158991(PersonTableDbInMemory personTableDbInMemory) {
        this.personTableDbInMemory = personTableDbInMemory;
    }

    @GetMapping("/api/v1/persons")
    public String getAllPersons() {
        return "personTableDbInMemory.getPersons();";
    }

    @PostMapping("/api/v1/persons")
    public Person createPerson(@RequestBody Person person) {
        return personTableDbInMemory.add(person);
    }

}
