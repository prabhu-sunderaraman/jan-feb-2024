package com.herbalife;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class HelloWorld implements QuarkusApplication {

    @Inject
    Person person;

    @Inject
    Car car1;

    @Inject
    Car car2;

    @Override
    public int run(String... args) throws Exception {

        System.out.println(car1);
        System.out.println(car1.getEngine());
        System.out.println(car1.getModel());
        System.out.println(car1.getEngine().getPower());
        System.out.println(car1.getInsurance());

        System.out.println(car2);
        System.out.println(car2.getEngine());


//        System.out.println("Hello Quarkus!");
//
//        //Person person = new Person();
//        person.setName("Joe");
//        System.out.println("Hello " + person.getName() + "!");

        return 0;
    }
}
