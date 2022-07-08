package ru.cft.project.loans.project_loans.model;


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long _id;

    // Amount of money on the balance
    @Column(name = "sum")
    private Long sum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id_person", referencedColumnName = "_id")
    private Person  person;

    public Balance() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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
