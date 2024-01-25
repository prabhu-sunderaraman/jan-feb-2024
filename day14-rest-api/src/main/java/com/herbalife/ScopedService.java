package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
//A singleton object that is instantiated lazily
public class ScopedService {
    public ScopedService() {
        System.out.println("*****ScopedService constructor called*****");
    }

    public String greet() {
        return "Welcome to Herbalife!";
    }
}
