package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class OrbitEmailQBD extends QueueByDateReport {


    private final static String reportName = "Orbit Email";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "EmailTable");

    public OrbitEmailQBD() {

        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\Orbit Irrigation Call Statistics FY 2015-2020.xlsx";
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
