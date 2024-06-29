package com.example.zal.Szczepan158991;


import com.example.zal.PersonTableDbInMemory;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Data
public class PersonService158991 {
    private final PersonTableDbInMemory personRepository;
    private final String txtPath = "persons.txt";  // Path to the text file
    private final String csvPath = "persons.csv";  // Path to the csv file


    public PersonService158991(PersonTableDbInMemory personRepository) {
        this.personRepository = personRepository;
    }

    public Person158991 createPerson(Person158991 person) {
        Person158991 savedPerson = personRepository.save(person);
        appendPersonToFile(savedPerson);
        return savedPerson;
    }

    public List<Person158991> getAllPersons() {
        return personRepository.findAllPersons();
    }

    public Person158991 getPersonById(String id) {
        Person158991 person = personRepository.findById(id);
        if (person == null) {
            throw new RuntimeException("Person with ID " + id + " not found");
        }
        return person;
    }

    public void deletePerson(String id) {
        personRepository.delete(id);
    }

    public Person158991 updatePerson(Person158991 person) {
        Person158991 updatedPerson = personRepository.update(person);
        if (updatedPerson == null) {
            throw new RuntimeException("Person with ID " + person.getId() + " not found");
        }
        return updatedPerson;
    }

    private void appendPersonToFile(Person158991 person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(personToString(person));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private String personToString(Person158991 person) {
        return person.getId() + "," + person.getName() + "," + person.getEmail();
    }
}