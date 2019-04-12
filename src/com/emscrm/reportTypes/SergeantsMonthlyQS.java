package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class SergeantsMonthlyQS extends QueueSummaryReport {
    private final static String reportName = "Sergeants Monthly";
    private final Map<String, String> tableNames = Map.of("Summary", "CallsTable");

    public SergeantsMonthlyQS() {
        this.weeklyReportFilename = "S:\\Reports\\Call Centers\\Sergeants\\Sergeants Statistics Overview 2015-2019.xlsx";
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
