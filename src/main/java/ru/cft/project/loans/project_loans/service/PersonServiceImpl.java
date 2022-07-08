package ru.cft.project.loans.project_loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person getPerson(Long id) {
        return personRepo.getPerson(id);
    }

    @Override
    public void addPerson(Person person) {
        personRepo.addPerson(person);
    }
}
