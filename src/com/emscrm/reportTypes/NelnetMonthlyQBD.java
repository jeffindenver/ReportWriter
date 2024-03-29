package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class NelnetMonthlyQBD extends QueueByDateReport {

    private final static String reportName = "Nelnet monthly calls";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public NelnetMonthlyQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Nelnet\\Nelnet Monthly Report 2020.xlsx";
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

