package ru.cft.project.loans.project_loans.repository.model;


import javax.persistence.*;

@Entity
public class Balance {
    @Id
    Long id;

    @Column(name = "sum")
    Long sum;

    @OneToOne
    @MapsId
    @JoinColumn(name = "_id_person")
    Person  person;
}
