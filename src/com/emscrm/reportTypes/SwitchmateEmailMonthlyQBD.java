package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class SwitchmateEmailMonthlyQBD extends QueueByDateReport {

    private final static String reportName = "Switchmate Email";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "EmailTable");

    public SwitchmateEmailMonthlyQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Switchmate\\Switchmate Monthly Report 2020.xlsx";
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
