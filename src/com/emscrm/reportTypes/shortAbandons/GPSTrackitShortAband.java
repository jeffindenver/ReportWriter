package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public final class GPSTrackitShortAband extends ShortAbandonReport {

    private static final String reportName = "GPS Trackit Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public GPSTrackitShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Weekly Stats 2020.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return false;
    }

    @Override
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
