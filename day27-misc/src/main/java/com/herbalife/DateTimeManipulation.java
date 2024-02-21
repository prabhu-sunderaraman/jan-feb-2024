package com.herbalife;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeManipulation {
    public static void main(String[] args) {
        //1.8 or Java 8 introduced a new package called java.time
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow);
        LocalTime nextHour = LocalTime.now().plusHours(1);
        System.out.println(nextHour);
        LocalDate parsedDate = LocalDate.parse("2021-12-21");
        System.out.println(parsedDate.getDayOfMonth() + " " + parsedDate.getMonthValue() + " " + parsedDate.getYear());

        //You can also format the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(parsedDate.format(formatter));
        LocalDate dob = LocalDate.parse("12/21/1990", formatter);
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println(age);
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        ZoneId est = ZoneId.of("Mexico/General");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(est);
        System.out.println(zonedDateTime);
    }
}
