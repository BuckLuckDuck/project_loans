package ru.cft.project.loans.project_loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.service.PersonServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public Person getPerson(
            @PathVariable Long id
    ) {
        Person person = personService.getPerson(id);

        if (person != null)
            return person;
        else
            return null; // TODO - Throws exception
    }

    @PostMapping(value = "/add")
    public Person addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return person;
    }

}
