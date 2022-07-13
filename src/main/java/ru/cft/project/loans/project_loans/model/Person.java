package ru.cft.project.loans.project_loans.model;


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // Person's name
    @Column(name = "name")
    private String name;

    // Person's surname
    @Column(name = "surname")
    private String surname;

    // Person's patronymics. If exist.
    @Column(name = "patronymics")
    private String patronymics;

    // Person's birthdate
    @Column(name = "birthdate")
    private String birthdate;

    // Series of person's passport
    @Column(name = "passport_series")
    private String passportSeries;

    // Number of person's passport
    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "pts")
    private String pts;

    @Column(name = "balance")
    @ColumnDefault("-1")
    private int balance;

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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String email) {
        this.birthdate = email;
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
