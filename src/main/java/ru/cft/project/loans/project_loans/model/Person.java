package ru.cft.project.loans.project_loans.model;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

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
    @Column(name = "email")
    private String email;

    @Column(name = "pts")
    private String pts;

    @Column(name = "balance", nullable = false)
    @ColumnDefault("-1")
    private int balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;


    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
