package ru.cft.project.loans.project_loans.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // Title of loan
    @Column(name = "title")
    private String title;

    // The amount left to be paid. Including rate
    @Column(name = "amount_left")
    private int amountLeft;

    // The amount that the client loaned from the service
    @Column(name = "amount_loan")
    private int loanAmount;

    // Interest rate
    @Column(name = "rate")
    private Double rate;

    // Date the loan was taken
    @Column(name = "start_date")
    private String startDate;

    // Last date of loan repayment
    @Column(name = "expiration_date")
    private String expirationDate;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", nullable = false)
    @JsonIgnore
    private Person person;

    public Loan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
