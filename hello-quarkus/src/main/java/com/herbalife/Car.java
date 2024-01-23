package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

//@Singleton
@ApplicationScoped
//@RequestScoped
//@SessionScoped
public class Car {
    @ConfigProperty(name = "mycar.model", defaultValue = "BMW")
    String model;

    @Inject
    Engine engine;

    @Inject
    @Named("thirdParty")
    Insurance insurance;

    public Insurance getInsurance() {
        return insurance;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }
}
