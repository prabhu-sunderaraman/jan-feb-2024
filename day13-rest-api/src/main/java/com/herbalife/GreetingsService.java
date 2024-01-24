package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingsService {
    public String getDefaultGreeting() {
        return "Hello World";
    }
}
