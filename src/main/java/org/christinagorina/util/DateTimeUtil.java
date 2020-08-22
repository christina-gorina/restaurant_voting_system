package org.christinagorina.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {
    private DateTimeUtil() {
    }

    public static LocalDateTime atStartOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    public static LocalDateTime atStartOfNextDay(LocalDate date) {
        return date.plus(1, ChronoUnit.DAYS).atStartOfDay();
    }
}
