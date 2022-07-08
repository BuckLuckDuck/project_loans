package ru.cft.project.loans.project_loans.model;

import javax.persistence.*;

@Entity
@Table(name = "promocode")
public class Promocode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Key of promocode
    @Column(name = "code")
    private String code;

    // Amount money to add
    @Column(name = "amount")
    private Long amount;

    // Description
    @Column(name = "description")
    private String description;

    public Promocode() {
    }

    public Promocode(String code, Long amount) {
        this.code = code;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
