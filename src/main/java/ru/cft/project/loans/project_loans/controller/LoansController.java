package ru.cft.project.loans.project_loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Loan;
import ru.cft.project.loans.project_loans.repository.LoansRepository;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoansController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LoansRepository loansRepository;

    @GetMapping("/person/{personId}/loans")
    public ResponseEntity<List<Loan>> getAllLoansByPersonId(
            @PathVariable(value = "personId") Long personId
    ) {
        List<Loan> loans = loansRepository.findByPersonId(personId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/person/{personId}/loans/{loanId}")
    public ResponseEntity<Loan> getLoanByPersonId(
            @PathVariable(value = "personId") Long personId,
            @PathVariable(value = "loanId") Long loanId
    ) {
        List<Loan> loans = loansRepository.findByPersonId(personId);
        Loan loan = null;
        for (Loan l : loans) {
            if (l.getId().equals(loanId))
                loan = l;
            break;
        }
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PostMapping("/person/{personId}/loans")
    public ResponseEntity<Loan> addLoan(
            @PathVariable(value = "personId") Long personId,
            @RequestBody Loan loanRequest
    ) {
        Optional<Loan> optional = personRepository.findById(personId).map(person -> {
            loanRequest.setPerson(person);
            return loansRepository.save(loanRequest);
        });
        Loan loan = optional.get();
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

}
