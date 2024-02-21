package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    public int product(int a, int b) {
        return a * b;
    }
}
