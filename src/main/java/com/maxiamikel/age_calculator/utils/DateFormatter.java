package com.maxiamikel.age_calculator.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class DateFormatter {

    private static List<DateTimeFormatter> DATE_FORMAT = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public static String formatInputDate(String inputDate) {
        for (DateTimeFormatter format : DATE_FORMAT) {
            try {
                LocalDate localDate = LocalDate.parse(inputDate, format);
                return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (Exception e) {

            }
        }
        throw new RuntimeException("Invalid input date format");
    }
}
