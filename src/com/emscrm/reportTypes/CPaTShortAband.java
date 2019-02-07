package com.emscrm.reportTypes;

public class CPaTShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "CPaT Short Abandons";
    private final int excelDataSheetIndex;

    public CPaTShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\cpat\\CPaT Weekly Stats 2019.xlsx";
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
