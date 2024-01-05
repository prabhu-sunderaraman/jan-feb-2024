package com.herbalife.labs.lab03;

public class Person {
    private String name;
    private City[] visitedCities;
    private Person friend;

    public Person(String name) {
        this.name = name;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City[] getVisitedCities() {
        return visitedCities;
    }

    public void setVisitedCities(City[] visitedCities) {
        this.visitedCities = visitedCities;
    }

    public String toString() {
        String info = """
                Name: %s,
                Visited cities: %s,
                Friend: %s
                """;
        if (visitedCities != null) {
            StringBuilder builder = new StringBuilder("\n");
            for (City city : visitedCities) {
                builder.append(city);
                builder.append("\n");
            }
            return info.formatted(name, builder.toString(), friend.getName());
        }
        return info.formatted(name, "None", friend.getName());
    }
}
