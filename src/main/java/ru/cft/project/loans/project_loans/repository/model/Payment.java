package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long _id;

    @Column(name = "time")
    String time;

    @Column(name = "amount")
    Long amount;

    @ManyToOne
    @JoinColumn(name = "_id_loan", referencedColumnName = "_id")
    Loan loan;
}
