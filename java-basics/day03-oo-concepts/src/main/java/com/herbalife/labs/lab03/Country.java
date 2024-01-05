package com.herbalife.labs.lab03;

public class Country {
    private String name;
    private String capital;
    private long population;

    public Country(String name, String capital, long population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String toString() {
        return "%s, Capital: %s, Population: %s".formatted(name, capital, population);
    }
}
