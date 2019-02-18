package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class RetailCSWTD extends QueueByDateReport {
    private final static String reportName = "Retail CS WTD";

    public RetailCSWTD() {
        this.excelDataSheetIndex = 25;
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
