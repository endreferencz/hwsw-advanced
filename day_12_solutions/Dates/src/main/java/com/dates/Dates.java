package com.dates;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Dates {

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2014, Month.FEBRUARY, 10));
        System.out.println(LocalDate.of(2014, 2, 10));
        System.out.println(LocalDate.ofYearDay(2010, 65));

        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(12, 0));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(2014, 10, 2, 12, 30));

        System.out.println(LocalTime.now(ZoneId.of("America/New_York")));
        System.out.println(LocalTime.now(Clock.systemUTC()));

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        System.out.println(now.toLocalDateTime());
        System.out.println(now.withZoneSameInstant(ZoneId.of("America/New_York")));
        now = now.plusHours(1);
        now = now.withMinute(0);
        now = now.withSecond(0);
        now = now.withNano(0);
        System.out.println(now);
    }

}
