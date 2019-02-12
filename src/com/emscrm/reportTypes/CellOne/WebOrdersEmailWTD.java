package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public class WebOrdersEmailWTD extends QueueByDateReport {
    private final static String reportName = "Web Orders Email WTD";

    public WebOrdersEmailWTD() {
        this.excelDataSheetIndex = 31;
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
