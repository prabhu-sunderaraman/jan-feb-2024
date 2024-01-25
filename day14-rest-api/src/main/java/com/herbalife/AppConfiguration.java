package com.herbalife;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

import java.util.List;

@ApplicationScoped
public class AppConfiguration {

    @Produces
    @DefaultBean
    public List<String> cities() {
        List<String> citiesInMexico = List.of("Mexico City", "Guadalajara", "Monterrey");
        return citiesInMexico;
    }
}
