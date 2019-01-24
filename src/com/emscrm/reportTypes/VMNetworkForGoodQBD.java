package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class VMNetworkForGoodQBD extends QueueByDateReport {

    private static final String reportName = "NetworkForGood VM";

    public VMNetworkForGoodQBD() {
        super(new String[]{"none"}, new String[]{"none"});
        this.excelDataSheetIndex = 2;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
