package com.herbalife;

import java.util.List;

public record PersonDto(String firstName, String lastName, int age, List<String> cars, List<String> dogs) {
}
