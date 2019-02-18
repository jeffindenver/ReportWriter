package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;


/**
 * @author JShepherd
 */
public final class CellOneQBD extends QueueByDateReport {

    private final static String reportName = "Cellular One";

    public CellOneQBD() {
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD.xlsx";
//        String[] workgroupNames = {"CellularOne Customer Care", "CellularOne Hotline", "CellularOne NM Activate",
//            "CellularOne NM Renew", "CellularOne Prepaid TS", "CellularOne Recertification", "CellularOne Retail CS",
//            "CellularOneRetail Payment", "CellularOne Retail TS"};
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
