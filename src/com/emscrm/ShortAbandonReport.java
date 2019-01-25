package com.emscrm;

import java.time.LocalDate;

public abstract class ShortAbandonReport implements Report {

    //the report will handle writing to the excel file. Pass the source list to the
    //run method of the class. Still return a string of the summary so that the csv file can be written.

    protected abstract int getShortAbandons();
    protected abstract void setShortAbandons(int abandons);
    public abstract String getWeeklyReportFilename();

    protected String weeklyReportFilename;
    protected int excelDataSheetIndex;
    private int shortAbandons;

    protected ShortAbandonReport() {
        shortAbandons = 0;
        excelDataSheetIndex = 0;
        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_ShortAbandonReport.xlsx";
    }

    public String run() {

        return String.valueOf(getShortAbandons());
    }
}
