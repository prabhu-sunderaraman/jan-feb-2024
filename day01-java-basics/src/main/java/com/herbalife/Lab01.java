package com.herbalife;

import java.util.Scanner;

public class Lab01 {

    public static final String AIM_LOWER = "Aim Lower";
    public static final String AIM_HIGHER = "Aim Higher";

    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing Game. Enter a number between 1 and 100.");
        Scanner scanner = new Scanner(System.in);
        int target = (int) (Math.random() * 100);
        int attempts = 0;
        String message = "";
        boolean gameOver = false;
        int guess = -1;

        //Is game over? No. Then enter the loop;
        while (!gameOver) { //As long as game is not Over, enter the loop
            guess = scanner.nextInt();
            attempts++;
            if (guess > target) {
                message = AIM_LOWER;
            } else if (guess < target) {
                message = AIM_HIGHER;
            } else if (guess == target) {
                gameOver = true;
                //message = "You've got it in " + attempts + " attempts"; //OLD STYLE
                message = "You've got it in %s attempts".formatted(attempts);
            }
            System.out.println(message);
        }

    }
}
