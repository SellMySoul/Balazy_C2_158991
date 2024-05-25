package com.example.zal;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonTableDbInMemory personTableDbInMemory;

    public PersonController(PersonTableDbInMemory personTableDbInMemory) {
        this.personTableDbInMemory = personTableDbInMemory;
    }

    @GetMapping("/api/v1/persons")
    public List<Person> getAllPersons() {
        return personTableDbInMemory.getPersons();
    }

    @PostMapping("/api/v1/persons")
    public Person createPerson(@RequestBody Person person) {
        return personTableDbInMemory.add(person);
    }

}
