package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class CellOne_Subtotal_WTD_QBD extends QueueByDateReport {

    private static final String reportName = "Cellular One Subtotal WTD";
    private final Map<String, String> weekToDateTableNames = Map.of("Grand Total:", "SubtotalWTD");

    public CellOne_Subtotal_WTD_QBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne Daily.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return true;
    }

    @Override
    public Map<String, String> getTargetTableNames() {
        return weekToDateTableNames;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }
}