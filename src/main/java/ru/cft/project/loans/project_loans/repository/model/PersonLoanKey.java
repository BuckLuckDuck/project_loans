package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;
import java.io.Serializable;


@Embeddable
public class PersonLoanKey implements Serializable {
    @Column(name = "_id_person")
    Long personId;

    @Column(name = "_id_loan")
    Long loanId;
}
