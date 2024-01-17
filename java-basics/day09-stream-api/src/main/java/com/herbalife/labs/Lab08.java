package com.herbalife.labs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lab08 {
    static List<Item> items = Arrays.asList(
            new Item("Nike", 20.45),
            new Item("Adidas", 31.45),
            new Item("Reebok", 29.25),
            new Item("Puma", 25.15),
            new Item("Fila", 15.15));

    public static void main(String[] args) {
        printTheNameAndPriceOfTheCostliestShoe();
        printTheNameAndPriceOfTheCheapestShoe();
        String csv = items
                .stream()
                .map(Item::getName)
                .collect(Collectors.joining(","));
        System.out.println(csv);
    }

    private static void printTheNameAndPriceOfTheCheapestShoe() {
        Item item = items
                .stream()
                .min(Comparator.comparing(Item::getPrice))//compare the price of each item and find the min
                .get();
        System.out.println("Cheapest item is %s ".formatted(item));

        item = items
                .stream()
                .reduce((initial, next) -> initial.getPrice() < next.getPrice() ? initial : next)
                .get();
        System.out.println("Cheapest item is %s ".formatted(item));
    }

    private static void printTheNameAndPriceOfTheCostliestShoe() {
        Item item = items
                .stream()
                .max(Comparator.comparing(Item::getPrice))//compare the price of each item and find the max
                .get();
        System.out.println("Costliest item is %s ".formatted(item));

        item = items
                .stream()
                .reduce((initial, next) -> initial.getPrice() > next.getPrice() ? initial : next)
                .get();
        System.out.println("Costliest item is %s ".formatted(item));
    }
}
