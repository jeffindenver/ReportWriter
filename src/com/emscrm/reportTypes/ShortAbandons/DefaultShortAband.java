package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public class DefaultShortAband extends ShortAbandonReport {

    private static final String reportName = "Default Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public DefaultShortAband() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\default QBD workbook.xlsx";
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
    public Map<String, String> getTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
