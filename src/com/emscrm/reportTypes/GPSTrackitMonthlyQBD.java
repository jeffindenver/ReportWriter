package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class GPSTrackitMonthlyQBD extends QueueByDateReport {

    private final static String reportName = "GPS Trackit Monthly";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public GPSTrackitMonthlyQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Monthly Report 2020.xlsx";
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
