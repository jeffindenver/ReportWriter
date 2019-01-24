package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class EmailNetworkForGoodQBD extends QueueByDateReport {

    private static final String reportName = "NetworkForGood Email";

    public EmailNetworkForGoodQBD() {
        super(new String[]{"none"}, new String[]{"none"});
        this.excelDataSheetIndex = 1;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
