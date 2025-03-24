package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
    private static final String DATE_PATTERN = "\\d{4}-\\d{2}-\\d{2}";

    public static boolean isValidFormat(String date) {
        return date.matches(DATE_PATTERN);  
    }

    public static boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
