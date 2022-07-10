package ru.cft.project.loans.project_loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "person/{id}")
    public ResponseEntity<Person> getPerson(
            @PathVariable("id") Long id
    ) {
        // TODO - Throw exception
        Optional<Person> optional = personRepository.findById(id);
        Person person = optional.get();
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PostMapping(value = "/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person _person = personRepository.save(person);
        return new ResponseEntity<>(_person, HttpStatus.CREATED);
    }

}
