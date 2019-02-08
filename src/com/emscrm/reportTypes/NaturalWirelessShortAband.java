package com.emscrm.reportTypes;

public class NaturalWirelessShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Natural Wireless Short Abandons";
    private final int excelDataSheetIndex;

    public NaturalWirelessShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Natural Wireless\\Natural Wireless Weekly Stats 2019.xlsx";
        excelDataSheetIndex = 0;
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
