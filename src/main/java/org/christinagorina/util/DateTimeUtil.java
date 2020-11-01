package org.christinagorina.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {
    public static final LocalDateTime VOTE_TIME_LIMIT = LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), 11, 0);
    private DateTimeUtil() {
    }

    public static LocalDateTime atStartOfDay(LocalDate date) {
        return date.atStartOfDay();
    }

    public static LocalDateTime atStartOfNextDay(LocalDate date) {
        return date.plus(1, ChronoUnit.DAYS).atStartOfDay();
    }

    public static boolean changeVote(LocalDateTime dateTime){
        if(VOTE_TIME_LIMIT.getYear() == dateTime.getYear() && VOTE_TIME_LIMIT.getMonth() == dateTime.getMonth() && VOTE_TIME_LIMIT.getDayOfMonth() == dateTime.getDayOfMonth() && VOTE_TIME_LIMIT.getHour() > dateTime.getHour()){
            return true;
        }else{
            return false;
        }

    }
}
