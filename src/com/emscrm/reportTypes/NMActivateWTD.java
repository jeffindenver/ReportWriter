package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

public class NMActivateWTD extends QueueByDateReport {
    private final static String reportName = "NM Activate WTD";

    public NMActivateWTD() {
        this.excelDataSheetIndex = 11;
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
