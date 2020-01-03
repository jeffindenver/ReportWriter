package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class MSRB_MonthlyEmailQBD extends QueueByDateReport {
    private static final String reportName = "MSRB Monthly Email";
    private final Map<String, String> weekToDateTableNames = Map.of("Grand Total:", "EmailTable");

    public MSRB_MonthlyEmailQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\MSRB\\MSRB Monthly Report 2019.xlsx";
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
