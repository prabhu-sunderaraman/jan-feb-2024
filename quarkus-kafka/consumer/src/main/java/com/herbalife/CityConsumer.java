package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class CityConsumer {

    @Incoming("city-channel")
    public void receiveCity(String city) {
        System.out.println("==== City received: " + city);
    }
}
