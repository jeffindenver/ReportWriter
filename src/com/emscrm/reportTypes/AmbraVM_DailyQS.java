package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class AmbraVM_DailyQS extends QueueSummaryReport {
    private final static String reportName = "Ambra Voice Mail Daily";
    private final Map<String, String> tableNames = Map.of("Summary", "VMTable");

    public AmbraVM_DailyQS() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Ambra\\Ambra Daily Report 2020.xlsx";
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