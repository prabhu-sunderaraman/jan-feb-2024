package com.herbalife.labs.lab03;

public class Lab03 {
    public static void main(String[] args) {
        Person sam = new Person("Sam");
        Country india = new Country("India", "New Delhi", 140000000L);
        Country usa = new Country("USA", "Washington DC", 40000000L);

        City pune = new City("Pune", india);
        City nyc = new City("New York City", usa);
        City[] cities = {pune, nyc};
        sam.setVisitedCities(cities);

        Person ram = new Person("Ram");
        sam.setFriend(ram);

        System.out.println(sam); //Automatically calls toString() method in Person class
    }
}
