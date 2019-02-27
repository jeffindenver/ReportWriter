package com.emscrm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationUtilityTest {

    @Test
    void toFractionOfDay() {

        String duration = "01:01:01";
        double expectedDuration = (3600.0 + 60.0 + 1.0) / 86400.0;
        double calculatedDuration = DurationUtility.toFractionOfDay(duration);
        double delta = .0001;

        assertEquals(expectedDuration, calculatedDuration, delta);

    }
}