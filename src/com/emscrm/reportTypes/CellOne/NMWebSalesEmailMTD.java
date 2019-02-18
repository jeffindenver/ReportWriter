package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class NMWebSalesEmailMTD extends QueueByDateReport {
    private final static String reportName = "NM Web Sales MTD";

    public NMWebSalesEmailMTD() {
        this.excelDataSheetIndex = 16;
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
