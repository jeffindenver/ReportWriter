package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public final class EmailEntrustQBD extends QueueByDateReport {

    private static final String reportName = "Entrust Email";

    public EmailEntrustQBD() {
        this.excelDataSheetIndex = 1;
        this.weeklyReportFilename = "s:\\Reports\\Call Centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
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
