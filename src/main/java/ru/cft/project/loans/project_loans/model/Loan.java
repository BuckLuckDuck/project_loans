package ru.cft.project.loans.project_loans.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long _id;

    // The amount left to be paid. Including rate
    @Column(name = "amount_left")
    Long amountLeft;

    // The amount that the client loaned from the service
    @Column(name = "amount_loan")
    private Long loanAmount;

    // Interest rate
    @Column(name = "rate")
    private Double rate;

    // Date the loan was taken
    @Column(name = "start_date")
    private String startDate;

    // Last date of loan repayment
    @Column(name = "expiration_date")
    private String expirationDate;

    // TODO - select CascadeTypes for this
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id_person")
    private Person person;

    @OneToMany(mappedBy = "loan")
    private List<Payment> payments;

    public Loan() {
    }

    public void addPaymentToLoan(Payment payment) {
        if (payments == null)
            payments = new ArrayList<>();
        payments.add(payment);
        payment.setLoan(this);
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Long getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(Long amountLeft) {
        this.amountLeft = amountLeft;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
