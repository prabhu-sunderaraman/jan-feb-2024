package com.herbalife.examples.orm.activeRecord;

import com.herbalife.examples.orm.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PersonService {

    @Transactional
    public void createPerson(Person person) {
        person.persist();
    }

    public List<Person> getPersons() {
        return Person.listAll();
    }

    @Transactional
    public void updateAge(int id, int age) {
        Optional<Person> optionalPerson = Person.findByIdOptional(id);
        optionalPerson.ifPresent(person -> {
            person.setAge(age);
            person.persist();
        });
    }

    @Transactional
    public void deletePerson(int id) {
        Optional<Person> optionalPerson = Person.findByIdOptional(id);
        optionalPerson.ifPresent(Person::delete);
    }
}
