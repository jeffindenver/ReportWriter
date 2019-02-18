package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public final class EmailNetworkForGoodQBD extends QueueByDateReport {

    private static final String reportName = "NetworkForGood Email";

    public EmailNetworkForGoodQBD() {
        this.excelDataSheetIndex = 1;
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
    public String toString() {
        return reportName;
    }
}
