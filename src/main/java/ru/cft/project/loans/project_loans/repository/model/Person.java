package ru.cft.project.loans.project_loans.repository.model;


import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "passport_series", nullable = false)
    String passportSeries;

    @Column(name = "passport_number", nullable = false)
    String passportNumber;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @Column(name = "email", nullable = false)
    String email;

    @OneToMany(mappedBy = "person")
    Set<LoanPerson> loanPersonSet;

    @OneToOne
    @PrimaryKeyJoinColumn
    Account account;

    @OneToOne
    @PrimaryKeyJoinColumn
    Balance balance;
}
