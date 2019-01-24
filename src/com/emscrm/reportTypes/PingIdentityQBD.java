package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class PingIdentityQBD extends QueueByDateReport {

    private final static String reportName = "PingIdentity";

    public PingIdentityQBD() {
        super(new String[]{"Ping Identity"}, new String[]{"None"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Ping Identity\\Ping Identity Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
