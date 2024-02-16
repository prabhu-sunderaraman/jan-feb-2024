package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/temperature")
public class TemperatureResource {

    @Inject
    private TemperatureService temperatureService;

    @GET
    @Path("/clearAll")
    public String clearAllCache() {
        temperatureService.clearAllCache();
        return "All caches are cleared.";
    }

    @GET
    @Path("/{city}/{country}")
    public String getTemperatureOf(String city, String country) {
        double temperature = temperatureService.getTemperatureOf(city, country);
        return "Temperature in " + city + " in " + country + " is " + temperature + " degree fahrenheit.";
    }


    @GET
    @Path("/{city}")
    public String getTemperature(String city) {
        double temperature = temperatureService.getTemperature(city);
        return "Temperature in " + city + " is " + temperature + " degree fahrenheit.";
    }
}
