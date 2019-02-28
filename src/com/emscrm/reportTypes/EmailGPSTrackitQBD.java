package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class EmailGPSTrackitQBD extends QueueByDateReport {

    private static final String reportName = "GPS Trackit Email";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "EmailTable");


    public EmailGPSTrackitQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Weekly Stats 2019.xlsx";
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
    public Map<String, String> getTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }

}
