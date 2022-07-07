package ru.cft.project.loans.project_loans.repository.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long _id;

    @Column(name = "sum")
    Long sum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id_person", referencedColumnName = "_id")
    Person  person;
}
