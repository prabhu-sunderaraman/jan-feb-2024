package com.herbalife.labs;

public class Lab06 {
    public static void main(String[] args) {
        int sumResult = operate(numbers -> {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            return sum;
        });
        System.out.println(sumResult);

        int squareResult = compute(num -> num * num);
        System.out.println(squareResult);
    }

    static int operate(Adder adder) {
        return adder.sum(5, 10, 15);
    }

    static int compute(Square square) {
        return square.fetch(5);
    }
}

@FunctionalInterface
interface Adder {
    int sum(int... numbers);
}

@FunctionalInterface
interface Square {
    int fetch(int num);
}
