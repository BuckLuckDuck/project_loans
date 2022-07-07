package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "loan_person")
public class LoanPerson {
    @EmbeddedId
    PersonLoanKey id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "_id_person")
    Person person;

    @ManyToOne
    @MapsId("loanId")
    @JoinColumn(name = "_id_loan")
    Loan loan;

}
