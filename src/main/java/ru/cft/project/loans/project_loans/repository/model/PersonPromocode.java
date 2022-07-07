package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "person_promocode")
public class PersonPromocode {
    @EmbeddedId
    PersonPromocodeKey id;

    Boolean isUsed;
}
