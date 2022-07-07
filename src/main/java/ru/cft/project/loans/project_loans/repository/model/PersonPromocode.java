package ru.cft.project.loans.project_loans.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "person_promocode")
public class PersonPromocode {
    @EmbeddedId
    PersonPromocodeKey id;


    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "_id_person")
    Person person;

    @ManyToOne
    @MapsId("promocodeId")
    @JoinColumn(name = "_id_promocode")
    Promocode promocode;

    Boolean isUsed;
}
