package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/persons")
public class PersonResource {

    @POST
    public void addPerson(Person person) {
        person.persist();
    }

    @GET
    public List<Person> getPersons() {
        return Person.listAll();
    }

    @PUT
    public void updateAge(Person person) {
        //find by first_name and last_name
        String query = "first_name like ?1 and last_name like ?2";
        Person
                .find(query, person.getFirstName(), person.getLastName())
                .firstResultOptional()
                .ifPresentOrElse(
                        p -> {
                            Person personObj = (Person) p;
                            personObj.setAge(person.getAge());
                            personObj.update();
                        },
                        () -> {
                            throw new RuntimeException("Person not found");
                        }
                );
    }
}
