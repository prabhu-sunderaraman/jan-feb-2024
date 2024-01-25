package com.herbalife;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;

import java.net.http.HttpClient;
import java.util.List;

public class AppConfiguration {

    @Produces
    @ApplicationScoped
    public List<String> cities() {
        List<String> citiesInMexico = List.of("Mexico City", "Guadalajara", "Monterrey");
        return citiesInMexico;
    }

    @Produces
    @ApplicationScoped
    public HttpClient httpClient() {
        return HttpClient.newBuilder().build();
    }
}
