package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class Engine {
    @ConfigProperty(name = "mycar.power", defaultValue = "1000")
    int power;

    public int getPower() {
        return power;
    }
}
