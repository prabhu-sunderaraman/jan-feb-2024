package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PersonService {

    public List<Person> getAllPersonsWithDogsGt(int dogCount) {
        String query = "from Person p join fetch p.dogs d where size(p.dogs) > ?1";
        List<Person> persons = Person.find(query, dogCount).list();
        return persons;
    }

    public List<Car> getCarsOwnedByPersonsWithAgeLt(int age) {
        String query = "from Car c join fetch c.owner p where p.age < ?1";
        List<Car> cars = Car.find(query, age).list();
        return cars;
    }

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
