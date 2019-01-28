package com.emscrm.reportTypes;

import java.time.LocalDate;

public class EntrustShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Entrust Short Abandons";
    protected int excelDataSheetIndex;
    private LocalDate date;

    public EntrustShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
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
