package com.emscrm.reportTypes;

import com.emscrm.FuzeQueueSummary;

import java.util.Map;

public class Queue3QS extends FuzeQueueSummary {

    public static final String reportName = "SC Queue3 monthly";

    private final Map<String, String> tableNames = Map.of("Report Totals", "Queue3Table2019");

    public Queue3QS() {
        super.weeklyReportFilename = "s:\\reports\\call Centers\\service channel\\service channel monthly 2019.xlsx";
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
        return "Queue3";
    }
}
