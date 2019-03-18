package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class EntrustQBD extends QueueByDateReport {

    private final static String reportName = "Entrust";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public EntrustQBD() {
        this.weeklyReportFilename = "s:\\Reports\\Call Centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
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
