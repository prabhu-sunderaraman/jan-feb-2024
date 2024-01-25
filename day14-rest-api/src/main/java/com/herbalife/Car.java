package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

@ApplicationScoped
//@Dependent
//@RequestScoped
//Will work only when you have Undertow as the server; Needs a different server configuration
//@SessionScoped
public class Car {
    public Car() {
        System.out.println("*****Car object created *****");
    }

    public int getCarMiles() {
        return (int) (Math.random() * 10000);
    }
}
