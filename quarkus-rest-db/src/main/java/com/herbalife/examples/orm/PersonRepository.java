package com.herbalife.examples.orm;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

//Similar to DAO class or the Repository pattern
@ApplicationScoped
public class PersonRepository implements PanacheRepositoryBase<Person, Integer> {
}
