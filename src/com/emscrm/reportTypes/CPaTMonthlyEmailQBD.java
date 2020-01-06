package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class CPaTMonthlyEmailQBD extends QueueByDateReport {

    private final static String reportName = "CPaT monthly calls";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "EmailTable");

    public CPaTMonthlyEmailQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\CPaT\\CPaT Monthly Report 2020.xlsx";
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
