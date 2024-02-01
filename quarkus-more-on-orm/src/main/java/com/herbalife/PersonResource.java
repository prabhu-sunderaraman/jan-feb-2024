package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/persons")
public class PersonResource {
    @Inject
    PersonService personService;

    @POST
    public void createPerson(PersonDto personDto) {
        personService.createPerson(personDto);
    }

    @GET
    @Path("/cars")
    public List<String> getAllCars() {
        System.out.println("*************Getting list of all cars*************");
        List<Car> cars = personService.getAllCars();
        System.out.println("*************Got list of all cars*************");
        return cars
                .stream()
                .map(Car::getModel)
                .toList();
    }

}
