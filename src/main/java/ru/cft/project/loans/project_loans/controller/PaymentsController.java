package ru.cft.project.loans.project_loans.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cft.project.loans.project_loans.model.Payment;
import ru.cft.project.loans.project_loans.service.PaymentsService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PaymentsController {

    private final PaymentsService paymentsService;

    @Autowired
    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @GetMapping("/person/{personId}/loans/{loanId}/payments")
    public ResponseEntity<List<Payment>> getAllPaymentsForLoanByLoanId(
            @PathVariable(value = "loanId") Long loanId
    ) {
        List<Payment> payments = paymentsService.getAllPaymentsForLoanByLoanId(loanId);
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @PostMapping("/person/{personId}/loans/{loanId}/payments")
    public ResponseEntity<Payment> addPayment(
            @PathVariable(value = "personId") Long personId,
            @PathVariable(value = "loanId") Long loanId,
            @RequestBody Payment paymentRequest
    ) {
        Payment payment = paymentsService.addPayment(personId, loanId, paymentRequest);
        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        return e.getMessage();
    }

}
