package ru.cft.project.loans.project_loans.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.service.PersonService;

@Slf4j
@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "person/{id}")
    public ResponseEntity<Person> getPerson(
            @PathVariable("id") Long id
    ) {
        Person person = personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }


    // TODO - log
    @PostMapping(value = "/person/{id}")
    public ResponseEntity<Person> addPerson(
            @RequestBody Person person,
            @PathVariable Long id
    ) {
        Person _person = personService.addPerson(id, person);
        return new ResponseEntity<>(_person, HttpStatus.CREATED);
    }

    @PostMapping(value = "person/{id}/balance")
    public ResponseEntity<Integer> addMoneyToBalance(
            @PathVariable("id") Long id,
            @RequestBody int money
    ) {
        int balance = personService.addMoneyToBalance(id, money);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @PutMapping (value = "person/{id}/balance")
    public ResponseEntity<Integer> withdrawMoneyFromBalance(
            @PathVariable("id") Long id,
            @RequestBody int money
    ) {
        try {
            return new ResponseEntity<>(personService.withdrawMoneyFromBalance(id, money), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
