package ru.cft.project.loans.project_loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.project.loans.project_loans.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
