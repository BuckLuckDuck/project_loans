package ru.cft.project.loans.project_loans.model;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long _id;

    // Person's name
    @Column(name = "name", nullable = false)
    private String name;

    // Person's surname
    @Column(name = "surname", nullable = false)
    private String surname;

    // Person's patronymics. If exist.
    @Column(name = "patronymics")
    private String patronymics;

    // Series of person's passport
    @Column(name = "passport_series", nullable = false)
    private String passportSeries;

    // Number of person's passport
    @Column(name = "passport_number", nullable = false)
    private String passportNumber;

    // Person's phone number
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    // Person's email
    @Column(name = "email", nullable = false)
    private String email;

    // List of person's loans
    // TODO - cascade types
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Loan> loansList;

    @OneToOne(mappedBy = "person")
    private Account account;

    @OneToOne(mappedBy = "person")
    private Balance balance;

    public Person() {
    }

    public void addLoanToPerson(Loan loan) {
        if (loansList == null)
            loansList = new ArrayList<>();

        loansList.add(loan);
        loan.setPerson(this);
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymics() {
        return patronymics;
    }

    public void setPatronymics(String patronymics) {
        this.patronymics = patronymics;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Loan> getLoansList() {
        return loansList;
    }

    public void setLoansList(List<Loan> loansList) {
        this.loansList = loansList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
