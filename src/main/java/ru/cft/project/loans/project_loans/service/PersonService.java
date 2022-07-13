package ru.cft.project.loans.project_loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.project.loans.project_loans.model.Account;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPerson(Long id) {
        Optional<Person> optional = Optional.ofNullable(personRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Такой пользователь не найден.")));
        return optional.get();
    }

    public Person addPerson(Long id, Person personForAdd) {
        personForAdd.setId(id);
        return personRepository.save(personForAdd);
    }

    public int addMoneyToBalance(Long id, int money) {
        Optional<Person> optional = personRepository.findById(id);
        Person person = optional.get();
        person.setBalance(person.getBalance() + money);
        personRepository.save(person);
        return person.getBalance();
    }

    public int withdrawMoneyFromBalance(Long id, int money) {
        Optional<Person> optional = personRepository.findById(id);
        Person person = optional.get();
        int balanceNow = person.getBalance();
        if (balanceNow < Math.abs(money)) {
            throw new IllegalArgumentException();
        } else {
            person.setBalance(balanceNow - Math.abs(money));
            personRepository.save(person);
            return person.getBalance();
        }
    }
}
