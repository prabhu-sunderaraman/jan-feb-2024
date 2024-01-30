package com.herbalife.examples.orm;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void updateAge(int id, int age) {
        Optional<Person> optionalPerson = personRepository.findByIdOptional(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setAge(age);
            personRepository.persist(person);
        }
    }
}
