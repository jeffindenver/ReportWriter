package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public final class OrbitCallbacksQBD extends QueueByDateReport {

    private final static String reportName = "Orbit";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallbacksTable");

    public OrbitCallbacksQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\Orbit Irrigation Call Statistics FY 2015-2019.xlsx";
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
