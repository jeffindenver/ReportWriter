package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public class GPSTrackitMonthlyShortAband extends ShortAbandonReport {

    private static final String reportName = "GPS Monthly Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public GPSTrackitMonthlyShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Monthly Report 2020.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return false;
    }

    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
