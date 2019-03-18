package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public final class NelnetShortAband extends ShortAbandonReport {

    private final static String reportName = "Nelnet Short Aband";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public NelnetShortAband() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Nelnet\\Nelnet Weekly Stats 2019.xlsx";
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

