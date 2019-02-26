package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

/**
 * @author JShepherd
 */
public final class VMNetworkForGoodQBD extends QueueByDateReport {

    private static final String reportName = "NetworkForGood VM";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "VMTable");

    public VMNetworkForGoodQBD() {
        this.excelDataSheetIndex = 2;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
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
