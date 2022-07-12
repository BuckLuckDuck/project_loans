package ru.cft.project.loans.project_loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.project.loans.project_loans.model.Loan;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.LoansRepository;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoansService {

    private final PersonRepository personRepository;
    private final LoansRepository loansRepository;

    @Autowired
    public LoansService(PersonRepository personRepository, LoansRepository loansRepository) {
        this.personRepository = personRepository;
        this.loansRepository = loansRepository;
    }

    public List<Loan> getAllLoansByPersonId(Long personId) {
        return loansRepository.findByPersonId(personId);
    }

    public Loan getLoanByPersonId(Long personId, Long loanId) {
        List<Loan> loans = loansRepository.findByPersonId(personId);
        Loan loan = null;
        for (Loan l : loans) {
            if (l.getId().equals(loanId))
                loan = l;
            break;
        }
        return loan;
    }

    public Loan addLoan(Long personId, Loan loan) {
        Optional<Loan> optional = personRepository.findById(personId).map(person -> {
            loan.setPerson(person);
            return loansRepository.save(loan);
        });
        Optional<Person> optionalPerson = personRepository.findById(personId);
        Person person = optionalPerson.get();
        person.setBalance(person.getBalance() + loan.getLoanAmount());
        personRepository.save(person);
        return optional.get();
    }
}
