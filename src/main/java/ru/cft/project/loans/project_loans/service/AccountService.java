package ru.cft.project.loans.project_loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cft.project.loans.project_loans.model.Account;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.AccountRepository;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, PersonRepository personRepository) {
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }


    public Long addUser(Account account) {
        if (accountRepository.getAccountByLogin(account.getLogin()) != null)
            throw new IllegalArgumentException();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        account.setPassword(encoder.encode(account.getPassword()));
        Person person = new Person();
        Long idPerson = personRepository.save(person).getId();
        account.setPerson(person);
        accountRepository.save(account);
        return idPerson;
    }

    public Long checkUser(Account account) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        Account _account = accountRepository.getAccountByLogin(account.getLogin());
        if (_account != null && encoder.matches(account.getPassword(), _account.getPassword()))
            return _account.getId();
        else
            return null;
    }
}
