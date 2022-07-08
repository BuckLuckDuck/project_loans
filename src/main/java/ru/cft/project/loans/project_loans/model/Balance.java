package ru.cft.project.loans.project_loans.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // Amount of money on the balance
    @Column(name = "sum")
    private Long sum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", referencedColumnName = "id")
    private Person  person;

    public Balance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
