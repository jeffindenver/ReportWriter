package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public class OrbitHydroRainShortAband extends ShortAbandonReport {
    private static final String reportName = "Orbit Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public OrbitHydroRainShortAband() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\Orbit HydroRain Call Statistics 2019.xlsx";
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
