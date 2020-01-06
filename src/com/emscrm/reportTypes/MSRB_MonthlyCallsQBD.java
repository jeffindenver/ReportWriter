package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class MSRB_MonthlyCallsQBD extends QueueByDateReport {
    private static final String reportName = "MSRB Monthly Calls";
    private final Map<String, String> weekToDateTableNames = Map.of("Grand Total:", "CallsTable");

    public MSRB_MonthlyCallsQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\MSRB\\MSRB Monthly Report 2020.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return false;
    }

    @Override
    public Map<String, String> getTargetTableNames() {
        return weekToDateTableNames;
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
