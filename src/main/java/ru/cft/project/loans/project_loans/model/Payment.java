package ru.cft.project.loans.project_loans.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long _id;

    // The time the payment was made
    // TODO - Calculated by the server
    @Column(name = "time")
    private String time;

    // Amount of money in payment
    @Column(name = "amount")
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "_id_loan", referencedColumnName = "_id")
    private Loan loan;

    public Payment() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
