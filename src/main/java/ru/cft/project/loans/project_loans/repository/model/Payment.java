package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    Long id;

    @Column(name = "time")
    String time;

    @Column(name = "amount")
    Long amount;

    @ManyToOne
    @MapsId
    @PrimaryKeyJoinColumn(name = "_id_loan")
    Loan loan;
}
