package com.herbalife.examples.orm;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/persons")
public class PersonResource {
    @Inject
    PersonService personService;

    @PUT
    @Path("/id/{id}/age/{age}") // http://localhost:8080/persons/id/1/age/30
    public void updateAge(@PathParam("id") int id, @PathParam("age") int age) {
        personService.updateAge(id, age);
    }

    @GET
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @POST
    public void createPerson(Person person) {
        personService.createPerson(person);
    }
}