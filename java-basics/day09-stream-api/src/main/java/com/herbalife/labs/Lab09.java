package com.herbalife.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab09 {
    static List<String> lines;
    static final Function<String, String> cityParseFunction = line -> line.split(",")[0];
    static final Function<String, String> countryParseFunction = line -> line.split(",")[1];
    static final String cityJson = """
                        {
                            "city": "%s",
                            "country": "%s",
                            "population": %s
                        }
            """;

    public static void main(String[] args) throws IOException {
        lines = Files.readAllLines(Paths.get("./cities.csv"));
        store("./cities.txt", cityParseFunction);
        store("./countries.txt", countryParseFunction);
        printCountOfCitiesGroupedByCountry();
        printTheNamesOfAllTheCities();
        generateJson("./places.json");
    }

    private static void generateJson(String fileName) throws IOException {
        String json = lines
                .stream()
                .skip(1)
                .map(Lab09::convertLineToJson)
                .collect(Collectors.joining(",\n", "[\n", "\n]"));
        Files.write(Paths.get(fileName), json.getBytes());
    }

    private static String convertLineToJson(String line) {
        String[] items = line.split(",");
        return cityJson.trim().formatted(items[0], items[1], items[2]);
    }

    private static void printTheNamesOfAllTheCities() {
        lines
                .stream()
                .skip(1)
                .map(cityParseFunction)
                .forEach(System.out::println);
    }

    private static void printCountOfCitiesGroupedByCountry() {
        Map<String, List<String>> items = lines
                .stream()
                .skip(1)
                .collect(Collectors.groupingBy(countryParseFunction));

        items.forEach((country, values) -> {
            System.out.println(country + ": " + values.size());
        });

    }

    private static void store(String fileName, Function<String, String> mapFunction) throws IOException {
        List<String> items = lines
                .stream()
                .skip(1)
                .map(mapFunction)
                .distinct()
                .collect(Collectors.toList());
        Files.write(Paths.get(fileName), items);
    }


}
