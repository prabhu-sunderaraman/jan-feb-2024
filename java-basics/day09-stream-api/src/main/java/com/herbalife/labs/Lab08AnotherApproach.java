package com.herbalife.labs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Lab08AnotherApproach {
    static List<Item> items = Arrays.asList(
            new Item("Nike", 20.45),
            new Item("Adidas", 31.45),
            new Item("Reebok", 29.25),
            new Item("Puma", 25.15),
            new Item("Fila", 15.15));

    public static void main(String[] args) {
        printTheNameAndPriceOf((initial, next) -> initial.getPrice() > next.getPrice() ? initial : next);
        printTheNameAndPriceOf((initial, next) -> initial.getPrice() < next.getPrice() ? initial : next);
    }

    private static void printTheNameAndPriceOf(BinaryOperator<Item> binaryOperator) {
        Item item = items
                .stream()
                .reduce(binaryOperator)
                .get();
        System.out.println("Item is %s ".formatted(item));
    }

}
