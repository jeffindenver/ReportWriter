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
        this.weeklyReportFilename = "s:\\reports\\call centers\\cpat\\CPaT Weekly Stats 2019.xlsx";
    }

    @Override
    public boolean overwrite() {
        return false;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    public Map<String, String> getTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }

}
