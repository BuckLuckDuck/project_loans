package ru.cft.project.loans.project_loans.repository.model;


import javax.persistence.*;
import javax.websocket.OnError;

@Entity
@Table(name = "contract")
public class Contract{
    @Id
    Long id;

    @Column(name = "amount_loan")
    Long loanAmount;

    @Column(name = "rate")
    Double rate;

    @Column(name = "start_date")
    String startDate;

    @Column(name = "expiration_date")
    String expirationDate;

    @OneToOne
    @MapsId
    @JoinColumn(name = "_id_loan")
    Loan loan;

}
