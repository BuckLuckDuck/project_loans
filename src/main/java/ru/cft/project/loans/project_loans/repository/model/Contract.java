package ru.cft.project.loans.project_loans.repository.model;


import javax.persistence.*;
import javax.websocket.OnError;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "contract")
public class Contract{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long _id;

    @Column(name = "amount_loan")
    Long loanAmount;

    @Column(name = "rate")
    Double rate;

    @Column(name = "start_date")
    String startDate;

    @Column(name = "expiration_date")
    String expirationDate;

    @OneToOne(mappedBy = "contract")
    Loan loan;

}
