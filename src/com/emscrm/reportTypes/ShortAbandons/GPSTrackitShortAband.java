package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

public class GPSTrackitShortAband extends ShortAbandonReport {

    private static final String reportName = "CPaT Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public GPSTrackitShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Weekly Stats 2019.xlsx";
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
