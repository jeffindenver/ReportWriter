package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class EntrustQBD extends QueueByDateReport {

    private final static String reportName = "Entrust";

    public EntrustQBD() {
        super(new String[]{"Entrust Main", "Entrust GCS Card Wizard", "Entrust GCS CE",
                "Entrust GCS English", "Entrust GCS PNC"}, new String[]{"Entrust Email"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\Reports\\Call Centers\\Entrust\\Entrust Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
