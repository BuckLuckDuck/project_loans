package ru.cft.project.loans.project_loans.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // User's login
    @Column(name = "login")
    private String login;

    // User's password
    @Column(name = "password_token")
    private String passwordToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person person;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordToken() {
        return passwordToken;
    }

    public void setPasswordToken(String passwordToken) {
        this.passwordToken = passwordToken;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
