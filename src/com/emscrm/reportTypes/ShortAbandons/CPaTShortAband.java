package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

public class CPaTShortAband extends ShortAbandonReport {

    private static final String reportName = "CPaT Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public CPaTShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\cpat\\CPaT Weekly Stats 2019.xlsx";
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
