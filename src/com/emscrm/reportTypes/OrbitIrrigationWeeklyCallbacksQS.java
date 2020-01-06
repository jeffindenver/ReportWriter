package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class OrbitIrrigationWeeklyCallbacksQS extends QueueSummaryReport {

    private final static String reportName = "Orbit Irrigation Calls Weekly";
    private final Map<String, String> tableNames = Map.of("Summary", "CallbacksTable");

    public OrbitIrrigationWeeklyCallbacksQS() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\Orbit Irrigation Weekly Stats 2020.xlsx";
    }

    @Override
    protected Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    protected String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    protected boolean isSingleLineTable() {
        return false;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
