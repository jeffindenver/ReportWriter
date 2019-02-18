package com.emscrm;

import java.time.Duration;

final class DurationUtility {

    private DurationUtility() {
    }

    static double toFractionOfDay(String duration) {
        System.out.println("In method toFractionOfDay. Duration equals " + duration);
        String[] v = duration.split(":");
        Duration someTime = Duration.ZERO;
        someTime = someTime.plusHours(Long.parseLong(v[0]));
        someTime = someTime.plusMinutes(Long.parseLong(v[1]));
        someTime = someTime.plusSeconds(Long.parseLong(v[2]));

        double totalTime = someTime.toMillis() / 1000.0;

        //Excel represents time as a fraction. 0.25 is six hours or 6:00 AM
        int secondsInADay = 86400;
        return totalTime / secondsInADay;
    }
}
