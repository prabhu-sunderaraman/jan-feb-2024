package com.herbalife;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PersonService {
    @Inject
    PersonRepository personRepository;


    @WithTransaction
    public Uni<Person> createPerson(Person person) {
        return personRepository.persist(person);
    }
    @WithSession
    //@Blocking //Error - @Blocking is allowed only on entrypoint methods
    public Uni<List<Person>> getPersons() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return personRepository.listAll();
    }

    @WithTransaction
    public Uni<List<Person>> getPersonsList() {
        System.out.println("====== getPersonsList called on " + Thread.currentThread().getName());
        return personRepository.listAll();
    }
}
