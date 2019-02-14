package com.emscrm.reportTypes.ShortAbandons;

public class NaturalWirelessShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Natural Wireless Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public NaturalWirelessShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Natural Wireless\\Natural Wireless Weekly Stats 2019.xlsx";
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
