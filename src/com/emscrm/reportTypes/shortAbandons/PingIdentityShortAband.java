package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public final class PingIdentityShortAband extends ShortAbandonReport {

    private static final String reportName = "Ping Identity Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public PingIdentityShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Ping Identity\\Ping Identity Weekly Stats 2020.xlsx";
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
