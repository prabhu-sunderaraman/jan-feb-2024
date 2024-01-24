package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/greetings")
public class GreetingsResource {

    @ConfigProperty(name = "welcome.message")
    String welcomeMessage;

    @Inject
    GreetingsService greetingsService;

    @GET
    @Path("/welcome")
    public String welcome() {
        return welcomeMessage;
    }

    @GET
    @Path("/hello")
    public String hello() {
        return greetingsService.getDefaultGreeting();
    }

    @POST
    @Path("/bye")
    public String bye() {
        return "Bye bye";
    }

    @GET
    @Path("/hi/{name}")
    public String hi(@PathParam("name") String name) {
        return "Hi " + name;
    }

    @POST
    @Path("/seeya")
    public String seeya(@QueryParam("name") String name) {
        return "See ya " + name;
    }

    @POST
    @Path("/adios")
    public String adios(@FormParam("name") String name) {
        return "Adios " + name;
    }

    @POST
    @Path("/hola")
    public String hola(@HeaderParam("name") String name) {
        return "Hola " + name;
    }

}
