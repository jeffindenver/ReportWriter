package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class OrbitBhyveWeeklyChatQS extends QueueSummaryReport {
    private final static String reportName = "Orbit Bhyve Chats Weekly";
    private final Map<String, String> tableNames = Map.of("Summary", "ChatTable");

    public OrbitBhyveWeeklyChatQS() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\Orbit b-hyve Weekly Stats 2019.xlsx";
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
