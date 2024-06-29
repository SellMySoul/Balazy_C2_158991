package com.example.zal;

import java.util.ArrayList;
import java.util.List;

import com.example.zal.Szczepan158991.Person158991;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PersonTableDbInMemory {

    List<Person> persons = new ArrayList<>();
    private String id;

    public Person add(Person person) {
        persons.add(person);
        return person;
    }

    List<Person> getPersons() {
        return persons;
    }

    public Person158991 findById(String id) {
        this.id = id;
    }

    public Person158991 save(Person158991 person) {
    }

    public List<Person158991> findAllPersons() {
    }

    public void delete(String id) {
    }

    public Person158991 update(Person158991 person) {
    }
}
