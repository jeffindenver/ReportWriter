package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public class SwitchmateMonthlyShortAband extends ShortAbandonReport {

    private static final String reportName = "Switchmate Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public SwitchmateMonthlyShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Switchmate\\Switchmate Monthly Report 2020.xlsx";
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
