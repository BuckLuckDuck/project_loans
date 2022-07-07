package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

import java.beans.ConstructorProperties;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    Long id;


    @Column(name = "login")
    String login;

    @Column(name = "password_token")
    String passwordToken;

    @OneToOne
    @MapsId
    @JoinColumn(name = "_id_person")
    Person person;
}
