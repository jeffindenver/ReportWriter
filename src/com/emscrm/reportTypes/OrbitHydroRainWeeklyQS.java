package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class OrbitHydroRainWeeklyQS extends QueueSummaryReport {
    private final static String reportName = "Orbit HydroRain Weekly";
    private final Map<String, String> tableNames = Map.of("Summary", "CallsTable");

    public OrbitHydroRainWeeklyQS() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\HydroRain Weekly Stats 2020.xlsx";
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
