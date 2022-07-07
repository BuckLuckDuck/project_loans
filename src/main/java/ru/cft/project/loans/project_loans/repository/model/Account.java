package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

import java.beans.ConstructorProperties;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long _id;


    @Column(name = "login")
    String login;

    @Column(name = "password_token")
    String passwordToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id_person", referencedColumnName = "_id")
    Person person;
}
