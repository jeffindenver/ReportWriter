package com.emscrm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFilterTest {

    private ListFilter listFilter = new ListFilter();
    private String separator = "\t";
    private List<String> list;

    @BeforeEach
    void setUp() {

        list = Arrays.asList("a", "a\tb\tc\td", "e\tf\tg\th");
    }

    @Test
    void filterByLength() {
        int minLength = 2;
        List<String> resultList = listFilter.filterByLength(minLength, list, separator);

        assertEquals(2, resultList.size());
    }
}