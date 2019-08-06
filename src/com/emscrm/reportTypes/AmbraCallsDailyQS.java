package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class AmbraCallsDailyQS extends QueueSummaryReport {
    private final static String reportName = "Ambra Calls Daily";
    private final Map<String, String> tableNames = Map.of("Summary", "CallsTable");

    public AmbraCallsDailyQS() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Ambra\\Ambra Daily Report 2019.xlsx";
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
