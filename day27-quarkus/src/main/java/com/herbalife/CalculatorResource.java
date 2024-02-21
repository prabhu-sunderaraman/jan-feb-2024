package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/calculator")
public class CalculatorResource {

    @Inject
    CalculatorService calculatorService;

    @GET
    @Path("/sum/{a}/{b}")
    public int sum(int a, int b) {
        return calculatorService.sum(a, b);
    }

    @POST
    @Path("/product/{a}/{b}")
    public int product(int a, int b) {
        return calculatorService.product(a, b);
    }
}
