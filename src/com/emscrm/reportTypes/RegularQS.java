package com.emscrm.reportTypes;

import com.emscrm.FuzeQueueSummary;

import java.util.Map;

public class RegularQS extends FuzeQueueSummary {

    public static final String reportName = "SC Regular monthly";

    protected final Map<String, String> tableNames = Map.of("Report Totals", "RegularTable2019");

    public RegularQS() {
        super.weeklyReportFilename = "s:\\reports\\call Centers\\service channel\\service channel monthly 2019.xlsx";
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
