package com.emscrm;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DateParser {

    private Pattern pattern;

    DateParser(String regexPattern) {
        pattern = Pattern.compile(regexPattern);
    }

    boolean containsDate(String dateline) {
        Matcher matcher = pattern.matcher(dateline);
        return matcher.find();
    }

    LocalDate parseDate(String dateline) {
        System.out.println("Dateline is " + dateline);
        LocalDate date = LocalDate.of(1977, 5, 25);
        Matcher matcher = pattern.matcher(dateline);

        if (matcher.find()) {
            int month = Integer.parseInt(matcher.group(1));
            int day = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));
            date = LocalDate.of(year, month, day);
        }
        return date;
    }

}
