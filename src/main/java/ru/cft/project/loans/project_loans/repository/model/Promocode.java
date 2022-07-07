package ru.cft.project.loans.project_loans.repository.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "promocode")
public class Promocode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code")
    String code;

    @Column(name = "amount")
    Long amount;

    @Column(name = "description")
    String description;
}
