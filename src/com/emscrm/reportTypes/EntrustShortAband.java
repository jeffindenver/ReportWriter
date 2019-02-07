package com.emscrm.reportTypes;

public class EntrustShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Entrust Short Abandons";
    private final int excelDataSheetIndex;

    public EntrustShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
        excelDataSheetIndex = 0;

    }

    @Override
    public String formatCsvRow(String s) {
        return reportName + "," + s;
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    public String getReportName() {
        return reportName;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
