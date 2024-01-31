package com.herbalife.examples.orm;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/persons")
public class PersonResource {
    @Inject
    PersonService personService;


    @GET
    @Path("/names")
    public Object getNames() {
        return personService.getNames();
    }

    @GET
    @Path("/agebetween/{start}/{end}") // http://localhost:8080/persons/agebetween/20/30
    public List<Person> getPersonsAgeBetween(@PathParam("start") int start, @PathParam("end") int end) {
        return personService.getPersonsInAgeBetween(start, end);
    }


    @GET
    @Path("/firstnames")
    public List<String> getFirstNames() {
        return personService.getFirstNames();
    }

    @DELETE
    @Path("/id/{id}") // http://localhost:8080/persons/id/1
    public void deletePerson(@PathParam("id") int id) {
        personService.deletePerson(id);
    }

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