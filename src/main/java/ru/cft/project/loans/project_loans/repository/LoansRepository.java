package ru.cft.project.loans.project_loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.project.loans.project_loans.model.Loan;

import java.util.List;

public interface LoansRepository extends JpaRepository<Loan, Long> {

    List<Loan> findByPersonId(long personId);
}
