package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class NelnetQBD extends QueueByDateReport {

    private final static String reportName = "Nelnet";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public NelnetQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Nelnet\\Nelnet Weekly Stats 2019.xlsx";
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
