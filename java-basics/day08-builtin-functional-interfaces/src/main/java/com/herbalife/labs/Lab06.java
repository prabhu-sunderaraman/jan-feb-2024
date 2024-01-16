package com.herbalife.labs;

import java.util.List;
import java.util.function.Function;

public class Lab06 {
    public static void main(String[] args) {

        int sumResult = operate(numbers -> {
            int sum = 0;
            for (int i = 0; i < numbers.size(); i++) {
                sum += numbers.get(i);
            }
            return sum;
        });
        System.out.println(sumResult);

        int squareResult = compute(num -> num * num);
        System.out.println(squareResult);
    }

    static int operate(Function<List<Integer>, Integer> adder) {
        return adder.apply(List.of(5, 10, 15));
    }

    static int compute(Function<Integer, Integer> square) {
        return square.apply(5);
    }
}


