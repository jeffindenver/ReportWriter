package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class AmbraEmailDailyQS extends QueueSummaryReport {
    private final static String reportName = "Ambra Email Daily";
    private final Map<String, String> tableNames = Map.of("Summary", "EmailTable");

    public AmbraEmailDailyQS() {
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
