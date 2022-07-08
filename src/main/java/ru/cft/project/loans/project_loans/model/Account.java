package ru.cft.project.loans.project_loans.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long _id;

    // User's login
    @Column(name = "login")
    private String login;

    // User's password
    @Column(name = "password_token")
    private String passwordToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id_person", referencedColumnName = "_id")
    private Person person;

    public Account() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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
