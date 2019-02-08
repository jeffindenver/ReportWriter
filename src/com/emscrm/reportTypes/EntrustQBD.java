package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class EntrustQBD extends QueueByDateReport {

    private final static String reportName = "Entrust";

    public EntrustQBD() {
        this.excelDataSheetIndex = 0;
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
