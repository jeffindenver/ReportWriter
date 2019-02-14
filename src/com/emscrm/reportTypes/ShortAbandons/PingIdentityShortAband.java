package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

public class PingIdentityShortAband extends ShortAbandonReport {

    private static final String reportName = "Ping Identity Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public PingIdentityShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Ping Identity\\Ping Identity Weekly Stats 2019.xlsx";
    }

    protected int getDataSheetIndex() {
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
