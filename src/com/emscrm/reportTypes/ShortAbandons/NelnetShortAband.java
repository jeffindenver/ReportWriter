package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.QueueByDateReport;

public class NelnetShortAband extends QueueByDateReport {

    private final static String reportName = "Nelnet Short Aband";
    private final static int excelDataSheetIndex = 0;

    public NelnetShortAband() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Nelnet\\Nelnet Weekly Stats 2019.xlsx";
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }
}

