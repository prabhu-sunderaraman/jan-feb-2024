package com.herbalife;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturesInJava {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Futures in Java are used to represent the result of an asynchronous computation
        //Not very useful in a real world scenario because of the blocking nature of the get() method
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(() -> {
//            while(true) {
//                System.out.println("Hello from the other side");
//                MyThreadUtil.sleep(1000);
//            }
//        });
        //You want to start a new thread to do some work and return some value on completion in the future
        Future<Double> randomFuture = executorService.submit(() -> {
            int count = 0;
            while(count < 5) {
                System.out.println("... Generating random number");
                MyThreadUtil.sleep(2000);
                count++;
            }
            System.out.println("... Done generating random number");
            return Math.random() * 100;
        });
        System.out.println("============Before End of main");

        while(!randomFuture.isDone()) {
            System.out.println("Waiting for random number to be generated");
            MyThreadUtil.sleep(1000);
        }
        System.out.println("Random number is: " + randomFuture.get()); //Blocking call
        System.out.println("============End of main");
    }
}


class MyThreadUtil {
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}