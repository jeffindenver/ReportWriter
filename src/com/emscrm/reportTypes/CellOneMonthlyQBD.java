package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class CellOneMonthlyQBD extends QueueByDateReport {
    private static final String reportName = "Cellular One Monthly Total";
    private final Map<String, String> weekToDateTableNames = Map.of("Grand Total:", "SubtotalMTD");

    public CellOneMonthlyQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne Monthly.xlsx";
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
