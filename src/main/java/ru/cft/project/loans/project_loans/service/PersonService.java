package ru.cft.project.loans.project_loans.service;

import ru.cft.project.loans.project_loans.model.Person;

public interface PersonService {
    public Person getPerson(Long id);
    public void addPerson(Person person);
}
