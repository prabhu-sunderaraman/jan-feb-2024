package com.herbalife;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/")
public class SimpleResource {

    @GET
    @Path("hello/{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello, " + name + "!";
    }
}
