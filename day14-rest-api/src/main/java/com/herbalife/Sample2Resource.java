package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;

@Path("/sample2")
public class Sample2Resource {

    //@Inject
    AppConfiguration appConfiguration;

    @ConfigProperty(name = "topics")
    List<String> topics;


    //@Inject
    List<String> cities;

//    @GET
//    @Path("/cities")
//    public List<String> cities() {
//        return cities;
//    }

    @GET
    @Path("/topics")
    public List<String> topics() {
        return topics;
    }
}
