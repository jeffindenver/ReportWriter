package com.emscrm;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DateParser {

    private Pattern pattern;

    DateParser(String regexPattern) {
        pattern = Pattern.compile(regexPattern);
    }

    LocalDate parseDate(String dateline) {
            LocalDate date = LocalDate.MIN;
            Matcher matcher = pattern.matcher(dateline);

            if(matcher.matches()) {
                int month = Integer.parseInt(matcher.group(0));
                int day = Integer.parseInt(matcher.group(1));
                int year = Integer.parseInt(matcher.group(2));
                date = LocalDate.of(year, month, day);
            }
            return date;
    }

    boolean containsDate(String dateline) {
        Matcher matcher = pattern.matcher(dateline);
        return matcher.find();
    }

}
