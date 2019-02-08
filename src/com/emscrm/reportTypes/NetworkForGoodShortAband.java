package com.emscrm.reportTypes;

public class NetworkForGoodShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Network for Good Short Abandons";
    private final int excelDataSheetIndex;

    public NetworkForGoodShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";
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
