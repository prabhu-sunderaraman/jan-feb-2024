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

    @Inject
    Company company;

    @Inject
    DbSettings dbSettings;

    @Inject
    DbConstants dbConstants;

    @Inject
    Book book;

    @Override
    public int run(String... args) throws Exception {

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());

//        System.out.println(dbConstants.host());
//        System.out.println(dbConstants.port());
//        System.out.println(dbConstants.username());
//        System.out.println(dbConstants.password());
//        dbConstants.schemas().forEach(System.out::println);
//
//
//        System.out.println(dbSettings.getHost());
//        System.out.println(dbSettings.getPort());
//        System.out.println(dbSettings.getUsername());
//        System.out.println(dbSettings.getPassword());


//        System.out.println(company.getName());
//        System.out.println(company.getAddress());
//        System.out.println(company.getEmployeeCount());

//        System.out.println(car1);
//        System.out.println(car1.getEngine());
//        System.out.println(car1.getModel());
//        System.out.println(car1.getEngine().getPower());
//        System.out.println(car1.getInsurance());
//
//        System.out.println(car2);
//        System.out.println(car2.getEngine());


//        System.out.println("Hello Quarkus!");
//
//        //Person person = new Person();
//        person.setName("Joe");
//        System.out.println("Hello " + person.getName() + "!");

        return 0;
    }
}
