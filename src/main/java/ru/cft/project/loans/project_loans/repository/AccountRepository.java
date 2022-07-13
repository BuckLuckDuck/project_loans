package ru.cft.project.loans.project_loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.project.loans.project_loans.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByLogin(String login);
}
