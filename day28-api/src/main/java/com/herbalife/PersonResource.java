package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/persons")
public class PersonResource {
    @Inject
    PersonService personService;

    @POST
    public void createPerson(Person person) {
        personService.createPerson(person);
    }

    @GET
    public List<Person> getPersons() {
        return personService.getPersons();
    }
}
