package com.herbalife;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorService {
    public int sum(int a, int b) {
        Log.infov("Adding {0} and {1}", a, b);
        return a + b;
    }

    public int product(int a, int b) {
        if (a == 0 || b == 0) {
            Log.warnv("One of the numbers is 0: {0} and {1}", a, b);
        }
        Log.infov("Product of {0} and {1}", a, b);
        return a * b;
    }
}
