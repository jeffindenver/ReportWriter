package com.emscrm.reportTypes;

import com.emscrm.ShortAbandonReport;

import java.time.LocalDate;

public class PingIdentityShortAband extends ShortAbandonReport {

    private static final String reportName = "Ping Identity Short Abandons";
    protected int excelDataSheetIndex;
    private LocalDate date;

    public PingIdentityShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Ping Identity\\Ping Identity Weekly Stats 2019.xlsx";
        excelDataSheetIndex = 0;
        setDate(LocalDate.now());

    }

    public void setDate(LocalDate aDate) {
        date = aDate;
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
