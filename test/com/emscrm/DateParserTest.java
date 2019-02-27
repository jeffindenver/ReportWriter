package com.emscrm;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {
    private final DateParser dateParser = new DateParser();

    @Test
    void containsDate() {
        String dateline = "01/02/2019";
        boolean isValid;

        isValid = dateParser.containsDate(dateline);
        assertTrue(isValid);

        dateline = "";
        isValid = dateParser.containsDate(dateline);
        assertFalse(isValid);
    }

    @Test
    void parseDate() {
        String dateline = "11/12/2016";
        LocalDate expectedDate = LocalDate.of(2016, 11, 12);

        LocalDate resultDate = dateParser.parseDate(dateline);
        //expected, actual
        assertEquals(expectedDate, resultDate);
    }
}