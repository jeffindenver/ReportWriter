package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

public final class NetworkForGoodShortAband extends ShortAbandonReport {

    private static final String reportName = "Network for Good Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public NetworkForGoodShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";
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
