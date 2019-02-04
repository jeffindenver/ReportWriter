package com.emscrm.reportTypes;

import com.emscrm.ShortAbandonReport;

public class PingIdentityShortAband extends ShortAbandonReport {

    private static final String reportName = "Ping Identity Short Abandons";
    protected int excelDataSheetIndex;


    public PingIdentityShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Ping Identity\\Ping Identity Weekly Stats 2019.xlsx";
        excelDataSheetIndex = 0;

    }

   protected String formatCsvRow(String s) {
        return reportName + "," + s;
    }

    protected int getDataSheetIndex() {
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
