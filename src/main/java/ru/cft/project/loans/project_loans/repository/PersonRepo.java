package ru.cft.project.loans.project_loans.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.cft.project.loans.project_loans.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class PersonRepo {

    private final EntityManager entityManager;

    @Autowired
    public PersonRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person getPerson(Long id) {
        Person person;

        Session session = entityManager.unwrap(Session.class);
        person = session.get(Person.class, id);

        return person;
    }

    public void addPerson(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(person);
    }

}
