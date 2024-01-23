package com.herbalife;

import jakarta.inject.Singleton;

@Singleton
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
