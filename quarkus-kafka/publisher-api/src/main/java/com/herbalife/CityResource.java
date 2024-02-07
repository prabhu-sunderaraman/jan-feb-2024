package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@Path("/city")
public class CityResource {

    @Inject
    @Channel("city-channel")
    Emitter<String> cityEmitter;

    @POST
    @Path("/{cityName}")
    public String publishCityToKafka(@PathParam("cityName") String cityName) {
        //Publish city to Kafka code goes here
        cityEmitter.send(cityName);
        return "City " + cityName + " published to Kafka";
    }
}
