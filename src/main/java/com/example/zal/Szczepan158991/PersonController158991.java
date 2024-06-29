package com.example.zal.Szczepan158991;


import com.example.zal.PersonTableDbInMemory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequestMapping("/158991")
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

    @PostMapping(value = "/api/v1/persons", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person158991> createPerson(@RequestBody Person158991 person) {
        //zapis_do_plik
        String filePath = "path_to_your_file.txt"; // Zdefiniuj ścieżkę do pliku
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(person.toString()); // Tutaj zakładam, że metoda toString() klasy Person jest odpowiednio zdefiniowana
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build(); // Zwróć błąd, jeśli zapis się nie powiedzie
        }

        return ResponseEntity.ok(person);
    }

}
