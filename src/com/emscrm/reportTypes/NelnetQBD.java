package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class NelnetQBD extends QueueByDateReport {

    private final static String reportName = "Nelnet";

    public NelnetQBD() {
        super(new String[]{"Nelnet HigherED", "Nelnet K12", "Nelnet QuikPay"},
                new String[]{"none"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Nelnet\\Nelnet Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
