package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class YKHC_MonthlyCallsQBD extends QueueByDateReport {

    private static final String reportName = "YKHC";
    private static final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public YKHC_MonthlyCallsQBD() {
        weeklyReportFilename = "s:\\reports\\call centers\\YKHC\\YKHC Monthly Report 2019.xlsx";
    }

    @Override
    protected Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    protected String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    protected boolean isSingleLineTable() {
        return false;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
