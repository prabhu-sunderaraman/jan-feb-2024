package com.herbalife.examples.orm;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;

    @Inject
    EntityManager entityManager;

    @Transactional
    public void createPerson(Person person) {
        personRepository.persist(person);
    }

    public List<Person> getPersons() {
        return entityManager
                .createNativeQuery("select * from persons", Person.class)
                .getResultList();

//        return personRepository
//                .listAll();
    }

    @Transactional
    public void updateAge(int id, int age) {
        Optional<Person> optionalPerson = personRepository.findByIdOptional(id);
        optionalPerson.ifPresent(person -> {
            person.setAge(age);
            personRepository.persist(person);
        });
//        if (optionalPerson.isPresent()) {
//            Person person = optionalPerson.get();
//            person.setAge(age);
//            personRepository.persist(person);
//        }
    }

    @Transactional
    public void deletePerson(int id) {
        Optional<Person> optionalPerson = personRepository.findByIdOptional(id);
        optionalPerson.ifPresent(personRepository::delete);
    }

    public List<String> getFirstNames() {
        String query = "select first_name from persons"; //NOT RECOMMENDED
        return entityManager
                .createNativeQuery(query, String.class)
                .getResultList();
    }

    public List<String> getFirstNamesInJPQL() {
        //select p.first_name from persons p
        //JPQL
        String query = "select p.firstName from Person p";
        return personRepository
                .find(query)
                .project(String.class)
                .list();


//        return personRepository
//                .streamAll()
//                .map(Person::getFirstName)
//                .toList();

    }

    public List<Person> getPersonsInAgeBetween(int start, int end) {
        //Approach 3
        String query = "age between ?1 and ?2";
        return personRepository
                .find(query, start, end)
                .list();


        //Approach 2
//        String query = "select p from Person p where p.age between :start and :end";
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("start", start);
//        parameters.put("end", end);
//        return personRepository
//                .find(query, parameters)
//                .list();

        //Approach 1
//        String query = "select p from Person p where p.age between ?1 and ?2";
//        return personRepository
//                .find(query, start, end)
//                .list();

    }

    //I will get this working
    public Object getNames() {
        String jpql = "select p.firstName, p.lastName from Person p";
        personRepository.find(jpql, Object[].class).list().stream().forEach(it -> System.out.println(it.getClass().getName()));
        return personRepository
                .find(jpql)
                .list();

    }
}
