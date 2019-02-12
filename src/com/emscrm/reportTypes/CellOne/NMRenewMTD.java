package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public class NMRenewMTD extends QueueByDateReport {

    private final static String reportName = "NM Renew MTD";

    public NMRenewMTD() {
        this.excelDataSheetIndex = 14;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD.xlsx";
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
