package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(name = "amount_left")
    Long amountLeft;

    @OneToMany(mappedBy = "loan")
    Set<LoanPerson> loanPersonSet;

    @OneToOne
    @PrimaryKeyJoinColumn
    Contract contract;


}
