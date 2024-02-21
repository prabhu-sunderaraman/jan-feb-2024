package com.herbalife;

import java.util.ArrayList;
import java.util.List;

public class MyLibrary {
    private List<Integer> numbers;
    private SomeDummyClass someDummyClass;

    public SomeDummyClass getSomeDummyClass() {
        return someDummyClass;
    }

    public int getSize() {
        return numbers.size();
    }

    public void addNumber(int number) {
        if (numbers.contains(number)) {
            throw new RuntimeException("Number already exists in the library");
        }
        numbers.add(number);
    }

    public void removeNumber(int number) {
        if (!numbers.contains(number)) {
            throw new RuntimeException("Number does not exist in the library");
        }

        numbers.remove(Integer.valueOf(number));
    }
}
