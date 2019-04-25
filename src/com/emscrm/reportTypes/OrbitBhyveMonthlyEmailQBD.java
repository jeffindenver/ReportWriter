package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class OrbitBhyveMonthlyEmailQBD extends QueueByDateReport {

    private final static String reportName = "Orbit Bhyve Email";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "EmailTable");

    public OrbitBhyveMonthlyEmailQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\B-hyve Call Statistics FY 2017-2019.xlsx";
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
