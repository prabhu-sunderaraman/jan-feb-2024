package com.herbalife;

import java.util.Scanner;

public class Lab02 {
    public static void main(String[] args) {
        calculateTheSumOfOddNumbersBetween1To10001();
        calculateTheIntegerAverageOfAllNumbersFrom1To10001();
        computeValue();
        printWordsFromUserInput();
    }

    private static void printWordsFromUserInput() {
        StringBuilder builder = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while(count < 5) {
            System.out.println("Enter a word");
            String word = scanner.next();
            if(builder.toString().contains(word)) {
                System.out.println("Word %s is already present. You have entered %s words so far".formatted(word, count));
            } else {
                builder.append(word);
                builder.append(" "); //If you enter a word with space, the conditional check may fail
                count++;
            }
        }
        System.out.println(builder.toString().toUpperCase());
    }


    private static void computeValue() {
        int value = 0;
        String input = "+5 -1 +9 +5 -67 +5 -3 +2 -4 +6 +8 -13 +2 -4 +6 +18 -3 +2 -4 +6 +88 +15 -1 +9 +5 -67 +45 -3 +2 -4 +36 +8 -13 +2 -4 +6 +18 -3 +2 -74 +11 +109";
        String[] items = input.split(" ");
        for (String item : items) {
            int number = Integer.parseInt(item);
            value += number;
        }
        System.out.println("Computed output: %s".formatted(value));
    }

    private static void calculateTheIntegerAverageOfAllNumbersFrom1To10001() {
        int sum = 0;
        for (int i = 0; i <= 10001; i++) {
            sum += i;
        }
        int[] exclusionList = {10, 19, 21, 39, 309, 431, 643, 942, 1209, 7981, 8888, 9910};
        for (int number : exclusionList) {
            sum -= number;
        }
        int count = 10001 - exclusionList.length;
        int average = sum / count;
        System.out.println("Average of numbers between 1 and 10001 is %s".formatted(average));
    }

    private static void calculateTheSumOfOddNumbersBetween1To10001() {
        int sum = 0;
        for (int i = 0; i <= 10001; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        System.out.println("Sum of odd numbers is %s".formatted(sum));
    }
}
