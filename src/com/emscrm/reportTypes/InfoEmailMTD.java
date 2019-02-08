package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

public class InfoEmailMTD extends QueueByDateReport {
    private final static String reportName = "InfoEmail MTD";

    public InfoEmailMTD() {
        this.excelDataSheetIndex = 8;
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
