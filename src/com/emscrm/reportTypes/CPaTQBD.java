package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class CPaTQBD extends QueueByDateReport {

    private static final String reportName = "CPaT";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public CPaTQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\cpat\\CPaT Weekly Stats 2020.xlsx";
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
