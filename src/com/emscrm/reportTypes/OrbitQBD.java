package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class OrbitQBD extends QueueByDateReport {

    private final static String reportName = "Orbit";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public OrbitQBD() {

    }

    @Override
    public boolean overwrite() {
        return false;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public Map<String, String> getTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
