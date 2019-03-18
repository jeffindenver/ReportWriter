package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class PingIdentityQBD extends QueueByDateReport {

    private final static String reportName = "PingIdentity";
    private final Map<String, String> tableNames = Map.of("Grand Total:","CallsTable");

    public PingIdentityQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Ping Identity\\Ping Identity Weekly Stats 2019.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return false;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    public Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
