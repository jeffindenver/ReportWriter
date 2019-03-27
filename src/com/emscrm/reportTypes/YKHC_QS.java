package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class YKHC_QS extends QueueSummaryReport {

    private static final String reportName = "YKHC";
    private static final Map<String, String> tableNames = Map.of("Summary", "CallsTable");

    public YKHC_QS() {
        weeklyReportFilename = "s:\\reports\\call centers\\YKHC\\YKHC Monthly Report 2019.xlsx";
    }

    @Override
    protected Map<String, String> getTargetTableNames() {
        //@TODO add the table name map
        return null;
    }

    @Override
    protected String getWeeklyReportFilename() {
        //@TODO add the filename
        return null;
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
