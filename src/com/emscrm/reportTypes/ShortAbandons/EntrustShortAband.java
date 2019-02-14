package com.emscrm.reportTypes.ShortAbandons;

public class EntrustShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Entrust Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public EntrustShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
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
