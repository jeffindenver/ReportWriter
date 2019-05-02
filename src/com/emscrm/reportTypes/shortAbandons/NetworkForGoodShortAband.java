package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public final class NetworkForGoodShortAband extends ShortAbandonReport {

    private static final String reportName = "Network for Good Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public NetworkForGoodShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";
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