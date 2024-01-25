package com.herbalife;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/sample")
public class SampleResource {
    @Inject
    SampleService sampleService;
    @Inject
    ScopedService scopedService;

    @Inject
    Car car1;

    @Inject
    Car car2;

    @GET
    @Path("/cars")
    public void cars() {
        System.out.println("*****SampleResource.cars() called*****");
        car1.getCarMiles();
        car2.getCarMiles();
        System.out.println("*****Car1: " + car1 + "*****");
        System.out.println("*****Car2: " + car2 + "*****");

    }

    @PostConstruct
    public void init() {
        System.out.println("----- " + sampleService.getClass().getName());
        System.out.println("----- " + scopedService.getClass().getName());
    }

    @GET
    @Path("/greet2")
    public String greet2() {
        System.out.println("*****SampleResource.greet2() called*****");
        return scopedService.greet();
    }

    @GET
    @Path("/greet1")
    public String greet() {
        System.out.println("*****SampleResource.greet() called*****");
        return sampleService.greet();
    }
}
