package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class BhyveEmailMTD extends QueueByDateReport {
    private static final String reportName = "B-hyve email month to date";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "BhyveEmailTable");

    public BhyveEmailMTD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\EMS Goals FY 2020.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return true;
    }

    @Override
    public Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
