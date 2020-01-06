package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class OrbitHydroRainCallbackQBD extends QueueByDateReport {
    private final static String reportName = "Orbit HydroRain Callbacks";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallbackTable");

    public OrbitHydroRainCallbackQBD() {
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
