package com.emscrm;

import java.util.List;
import java.util.stream.Collectors;

class ListFilter {

    List<String> filterByLength(int minLength, List<String> list, String separator) {
        return list
                .stream()
                .filter((line) -> (validateDelimitedLength(line, minLength, separator)))
                .collect(Collectors.toList());
    }

    private boolean validateDelimitedLength(String s, int minLength, String delimiter) {
        boolean isValid = false;
        String[] v = s.split(delimiter);
        if (v.length > minLength) {
            isValid = true;
        }
        return isValid;
    }

}
