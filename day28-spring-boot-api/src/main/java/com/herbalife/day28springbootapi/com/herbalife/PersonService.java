package com.herbalife.day28springbootapi.com.herbalife;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
