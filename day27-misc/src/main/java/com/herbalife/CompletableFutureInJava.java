package com.herbalife;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureInJava {
    public static void main(String[] args) {
        //Similar to Promises in JavaScript
        //You can use it invoke APIs asynchronously without blocking the main thread
        //In C# you have Task and TaskCompletionSource
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture
                .supplyAsync(() -> {
                    int count = 0;
                    while (count < 5) {
                        System.out.println("... Generating random number");
                        MyThreadUtil.sleep(2000);
                        count++;
                    }
                    System.out.println("... Done generating random number");
                    double randomNumber = Math.random() * 100;
                    if (randomNumber < 50) {
                        throw new RuntimeException("Something went wrong " + 50);
                    }
                    return randomNumber;
                }, executorService)
                .thenAccept(result -> {
                    System.out.println("Random number is: " + result);
                })
                .exceptionally(throwable -> {
                    System.out.println("***********Error: " + throwable.getMessage());
                    return null;
                })
                .thenAccept(result -> {
                    System.out.println("Let me store the Random number in DB: ");
                })
                .thenAccept(result -> {
                    System.out.println("Let me send the Random number to a third party service: ");
                });
        System.out.println("============End of main");
        MyThreadUtil.sleep(20000);
    }
}
