package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public class RetailTSWTD extends QueueByDateReport {
    private final static String reportName = "Retail TS WTD";

    public RetailTSWTD() {
        this.excelDataSheetIndex = 29;
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