package ru.cft.project.loans.project_loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Loan;
import ru.cft.project.loans.project_loans.model.Payment;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.LoansRepository;
import ru.cft.project.loans.project_loans.repository.PaymentRepository;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaymentsController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person/{personId}/loans/{loanId}/payments")
    public ResponseEntity<List<Payment>> getAllLoansByPersonId(
            @PathVariable(value = "loanId") Long loanId
    ) {
        List<Payment> payments = paymentRepository.findByLoanId(loanId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping("/person/{personId}/loans/{loanId}/payments")
    public ResponseEntity<Payment> addPayment(
            @PathVariable(value = "personId") Long idPerson,
            @PathVariable(value = "loanId") Long idLoan,
            @RequestBody Payment paymentRequest
    ) {
        Optional<Person> optionalPerson = personRepository.findById(idPerson);
        Person person = optionalPerson.get();
        if (person.getBalance() < paymentRequest.getAmount())
            return null; // TODO - throw ExceptionNotEnoughMoney
        person.setBalance(person.getBalance() - paymentRequest.getAmount());
        personRepository.save(person);

        Optional<Loan> optionalLoan = loansRepository.findById(idLoan);
        Loan _loan = optionalLoan.get();
        // TODO - if need to check amount bigger than how many amount left
        _loan.setAmountLeft(_loan.getAmountLeft() - paymentRequest.getAmount());
        loansRepository.save(_loan);

        Optional<Payment> optionalPayment = loansRepository.findById(idLoan).map(loan -> {
            paymentRequest.setLoan(loan);
            return paymentRepository.save(paymentRequest);
        });
        Payment payment = optionalPayment.get();
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

}
