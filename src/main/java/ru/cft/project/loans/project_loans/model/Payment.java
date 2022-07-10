package ru.cft.project.loans.project_loans.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // The time the payment was made
    // TODO - Calculated by the server
    @Column(name = "time")
    private String time;

    // Amount of money in payment
    @Column(name = "amount")
    private int amount;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_loan", nullable = false)
    @JsonIgnore
    private Loan loan;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
