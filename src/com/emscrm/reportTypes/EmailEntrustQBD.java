package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class EmailEntrustQBD extends QueueByDateReport {

    private static final String reportName = "Entrust Email";

    public EmailEntrustQBD() {
        super(new String[]{"none"}, new String[]{"none"});
        this.excelDataSheetIndex = 1;
        this.weeklyReportFilename = "s:\\Reports\\Call Centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
