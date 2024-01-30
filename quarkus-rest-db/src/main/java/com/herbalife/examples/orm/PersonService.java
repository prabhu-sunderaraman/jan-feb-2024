package com.herbalife.examples.orm;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    @Transactional
    public void createPerson(Person person) {
        personRepository.persist(person);
    }

    public List<Person> getPersons() {
        return personRepository
                .listAll();
    }
}
