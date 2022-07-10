package ru.cft.project.loans.project_loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.project.loans.project_loans.model.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByLoanId(long loanId);
}
