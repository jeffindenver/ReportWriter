package com.emscrm.reportTypes;

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
