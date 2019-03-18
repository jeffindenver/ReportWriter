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
        //This report is not currently used, and no file exists. The default workbook is temporary.
        this.weeklyReportFilename = "s:\\reports\\call centers\\default QBD Workbook.xlsx";
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
