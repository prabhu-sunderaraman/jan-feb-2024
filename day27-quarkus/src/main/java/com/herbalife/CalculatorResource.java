package com.herbalife;

import io.quarkus.logging.Log;
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
        Log.infov("Summing {0} and {1}", a, b);
        return calculatorService.sum(a, b);
    }

    @POST
    @Path("/product/{a}/{b}")
    public int product(int a, int b) {
        Log.infov("Multiplying {0} and {1}", a, b);
        return calculatorService.product(a, b);
    }
}
