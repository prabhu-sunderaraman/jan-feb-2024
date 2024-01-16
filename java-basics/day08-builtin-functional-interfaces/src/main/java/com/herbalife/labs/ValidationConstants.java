package com.herbalife.labs;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public interface ValidationConstants {
    Predicate<String> isNotBlank = value -> !value.isBlank();
    Predicate<String> isNotNull = value -> value != null;
    Predicate<String> isNotEmpty = value -> !value.isEmpty();
    Predicate<String> isUsernameLengthValid = value -> value.length() >= 6 && value.length() <= 12;
    Predicate<String> isPasswordLengthValid = value -> value.length() >= 8 && value.length() <= 14;
    BiFunction<Integer, Integer, Predicate<String>> lengthValidation =
            (min, max) -> value -> value.length() >= min && value.length() <= max;

    Predicate<String> hasUpperCase = value -> value.matches(".*[A-Z].*");
    Predicate<String> hasNumber = value -> value.matches(".*\\d+.*");
}
