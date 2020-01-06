package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class NaturalWirelessQBD extends QueueByDateReport {
    private final static String reportName = "Natural Wireless";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public NaturalWirelessQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Natural Wireless\\Natural Wireless Weekly Stats 2020.xlsx";
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
