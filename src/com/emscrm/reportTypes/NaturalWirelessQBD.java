package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class NaturalWirelessQBD extends QueueByDateReport {
    private final static String reportName = "Natural Wireless";

    public NaturalWirelessQBD() {
        super(new String[]{"Natural Wireless"}, new String[]{"none"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Natural Wireless\\Natural Wireless Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
