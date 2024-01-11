package com.herbalife.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//THIS IS OLD STYLE OF CODING
//WE WILL REWRITE THIS USING LAMBDAS AND STREAM API
public class Lab05 {
    static Map<String, List<City>> countries = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String fileName = "./cities.csv";

        //java -jar -DfileName='somevalue' <jarFileName>
        if (System.getProperty("fileName") != null) {
            fileName = System.getProperty("fileName");
        }
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        populateCountriesList(lines);
        printAllTheCitiesGroupedByCountries();
        Collection<List<City>> values = countries.values();
        List<City> allCities = new ArrayList<>();
        for (List<City> cities : values) {
            allCities.addAll(cities);
        }
        printTheCityNameWithLargestPopulation(allCities);
        printTheCityNameWithSmallestPopulation(allCities);
        printPopulationOf("China");
    }

    private static void printPopulationOf(String country) {
        List<City> cities = countries.get(country);
        long total = 0;
        for (City city : cities) {
            total += city.population();
        }
        System.out.println("Population of %s is %s".formatted(country, total));
    }

    private static void printTheCityNameWithSmallestPopulation(List<City> allCities) {
        City smallestCity = allCities.get(0);
        for (City city : allCities) {
            if (city.population() < smallestCity.population()) {
                smallestCity = city;
            }
        }
        System.out.println("Smallest city is %s with population %s".formatted(smallestCity.name(), smallestCity.population()));
    }

    private static void printTheCityNameWithLargestPopulation(List<City> allCities) {
        City largestCity = allCities.get(0);
        for (City city : allCities) {
            if (city.population() > largestCity.population()) {
                largestCity = city;
            }
        }
        System.out.println("Largest city is %s with population %s".formatted(largestCity.name(), largestCity.population()));

    }

    private static void printAllTheCitiesGroupedByCountries() {
        for (String country : countries.keySet()) {
            System.out.println("****** " + country + " ******");
            List<City> cities = countries.get(country);
            for (City city : cities) {
                System.out.println(city);
            }
        }
    }

    private static void populateCountriesList(List<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] items = line.split(",");
            String cityName = items[0];
            String countryName = items[1];
            long population = Long.parseLong(items[2]);
            City city = new City(cityName, population);
            if (countries.containsKey(countryName)) {
                countries.get(countryName).add(city);
            } else {
                List<City> citiesList = new ArrayList<>();
                citiesList.add(city);
                countries.put(countryName, citiesList);
            }
        }
    }
}
