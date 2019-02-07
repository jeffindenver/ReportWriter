package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

public class CustomerCareWTD extends QueueByDateReport {
    private final static String reportName = "Customer Care WTD";

    public CustomerCareWTD() {
        this.excelDataSheetIndex = 5;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD.xlsx";
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    public String getReportName() {
        return reportName;
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