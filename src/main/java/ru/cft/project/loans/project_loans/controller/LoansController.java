package ru.cft.project.loans.project_loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Loan;
import ru.cft.project.loans.project_loans.service.LoansService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoansController {

    private final LoansService loansService;

    @Autowired
    public LoansController(LoansService loansService) {
        this.loansService = loansService;
    }

    @GetMapping("/person/{personId}/loans")
    public ResponseEntity<List<Loan>> getAllLoansByPersonId(
            @PathVariable(value = "personId") Long personId
    ) {
        List<Loan> loans = loansService.getAllLoansByPersonId(personId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/person/{personId}/loans/{loanId}")
    public ResponseEntity<Loan> getLoanByPersonId(
            @PathVariable(value = "personId") Long personId,
            @PathVariable(value = "loanId") Long loanId
    ) {
        Loan loan = loansService.getLoanByPersonId(personId, loanId);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PostMapping("/person/{personId}/loans")
    public ResponseEntity<Loan> addLoan(
            @PathVariable(value = "personId") Long personId,
            @RequestBody Loan loanRequest
    ) {
        Loan loan = loansService.addLoan(personId, loanRequest);
        return new ResponseEntity<>(loan, HttpStatus.CREATED);
    }

}
