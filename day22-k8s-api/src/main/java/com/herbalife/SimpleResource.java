package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class SimpleResource {
    @ConfigProperty(name = "welcome.message")
    String welcomeMessage;

    @ConfigProperty(name = "bye.message")
    String byeMessage;

    @Inject
    DatabaseCredentials databaseCredentials;

    @GET
    @Path("database")
    public String database() {
        return "URL: " + databaseCredentials.url() + ", Username: " + databaseCredentials.username() + ", Password: " + databaseCredentials.password();
    }


    @GET
    @Path("greetings")
    public String greetings() {
        return welcomeMessage + ". " + byeMessage;
    }

    @GET
    @Path("hello/{name}")
    public String hello(@PathParam("name") String name) {
        return "Hello, " + name + "!";
    }
}
