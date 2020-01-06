package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public class YKHC_MonthlyShortAband extends ShortAbandonReport {

    private static final String reportName = "YKHC Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public YKHC_MonthlyShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\YKHC\\YKHC Monthly Report 2020.xlsx";
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
