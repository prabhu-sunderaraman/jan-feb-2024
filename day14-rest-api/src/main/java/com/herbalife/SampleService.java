package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

@Singleton
public class SampleService {
    public SampleService() {
        System.out.println("*****SampleService constructor called*****");
    }

    public String greet() {
        return "Welcome to Herbalife!";
    }
}
