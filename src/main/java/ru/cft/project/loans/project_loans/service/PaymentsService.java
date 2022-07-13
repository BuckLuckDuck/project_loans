package ru.cft.project.loans.project_loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.project.loans.project_loans.model.Loan;
import ru.cft.project.loans.project_loans.model.Payment;
import ru.cft.project.loans.project_loans.model.Person;
import ru.cft.project.loans.project_loans.repository.LoansRepository;
import ru.cft.project.loans.project_loans.repository.PaymentRepository;
import ru.cft.project.loans.project_loans.repository.PersonRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {

    private final PaymentRepository paymentRepository;

    private final LoansRepository loansRepository;

    private final PersonRepository personRepository;

    @Autowired
    public PaymentsService(PaymentRepository paymentRepository, LoansRepository loansRepository, PersonRepository personRepository) {
        this.paymentRepository = paymentRepository;
        this.loansRepository = loansRepository;
        this.personRepository = personRepository;
    }

    public List<Payment> getAllPaymentsForLoanByLoanId(Long loanId) {
        return paymentRepository.findByLoanId(loanId);
    }

    public Payment addPayment(Long personId, Long loanId, Payment payment) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        Person person = optionalPerson.get();
        if (person.getBalance() < payment.getAmount())
            throw new IllegalArgumentException();
        person.setBalance(person.getBalance() - payment.getAmount());
        personRepository.save(person);

        Optional<Loan> optionalLoan = loansRepository.findById(loanId);
        Loan _loan = optionalLoan.get();
        // TODO - if need to check amount bigger than how many amount left
        _loan.setAmountLeft(_loan.getAmountLeft() - payment.getAmount());
        loansRepository.save(_loan);

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        payment.setTime(date.format(calendar.getTime()));

        Optional<Payment> optionalPayment = loansRepository.findById(loanId).map(loan -> {
            payment.setLoan(loan);
            return paymentRepository.save(payment);
        });
        return optionalPayment.get();
    }
}
