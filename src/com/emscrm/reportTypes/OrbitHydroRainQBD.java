package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class OrbitHydroRainQBD extends QueueByDateReport {
    private final static String reportName = "Orbit HydroRain";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public OrbitHydroRainQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\Orbit HydroRain Call Statistics 2020.xlsx";
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
