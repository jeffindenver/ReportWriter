package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class InfoEmailMTD extends QueueByDateReport {
    private final static String reportName = "InfoEmail MTD";
    private final static int excelDataSheetIndex = 8;

    public InfoEmailMTD() {
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
