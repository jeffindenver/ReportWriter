package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public class RetailPaymentWTD extends QueueByDateReport {
    private final static String reportName = "Retail Payment WTD";

    public RetailPaymentWTD() {
        this.excelDataSheetIndex = 27;
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
