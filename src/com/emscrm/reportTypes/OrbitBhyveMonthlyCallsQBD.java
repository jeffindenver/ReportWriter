package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class OrbitBhyveMonthlyCallsQBD extends QueueByDateReport {

    private final static String reportName = "Orbit Bhyve Calls";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public OrbitBhyveMonthlyCallsQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\B-hyve Call Statistics FY 2017-2020.xlsx";
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
