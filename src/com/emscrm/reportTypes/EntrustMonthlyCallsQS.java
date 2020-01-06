package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class EntrustMonthlyCallsQS extends QueueSummaryReport {
    private final static String reportName = "Entrust Monthly";
    private final Map<String, String> tableNames = Map.of("Summary", "CallsTable");

    public EntrustMonthlyCallsQS() {
        this.weeklyReportFilename = "S:\\Reports\\Call Centers\\Entrust\\Entrust Monthly Report 2020.xlsx";
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
