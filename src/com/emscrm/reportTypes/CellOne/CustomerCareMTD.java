package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class CustomerCareMTD extends QueueByDateReport {
    private static final String reportName = "Customer Care MTD";
    private static final int excelDataSheetIndex = 4;

    public CustomerCareMTD() {
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
