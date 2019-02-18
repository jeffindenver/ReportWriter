package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class CustomerCareWTD extends QueueByDateReport {
    private final static String reportName = "Customer Care WTD";
    private final static int excelDataSheetIndex = 5;

    public CustomerCareWTD() {
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
