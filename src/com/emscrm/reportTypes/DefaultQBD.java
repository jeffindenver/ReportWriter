package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class DefaultQBD extends QueueByDateReport {
    private static final String reportName = "DefaultQBD";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public DefaultQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\default QBD workbook.xlsx";
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
