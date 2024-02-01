package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

    @Transactional
    public void createPerson(PersonDto personDto) {

        Person person = new Person();
        person.setFirstName(personDto.firstName());
        person.setLastName(personDto.lastName());
        person.setAge(personDto.age());
        person.persist();

        List<Dog> dogs = new ArrayList<>();
        personDto.dogs().forEach(dogName -> {
            Dog dog = new Dog();
            dog.setName(dogName);
            dog.setOwner(person);
            dog.persist();
//            dogs.add(dog);
        });
//        person.setDogs(dogs);
//        person.persist();



        personDto.cars().forEach(model -> {
            Car car = new Car();
            car.setModel(model);
            car.setOwner(person);
            car.persist();
        });
    }

    public List<Car> getAllCars() {
        return Car.listAll();
    }
}
