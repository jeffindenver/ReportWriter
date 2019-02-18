package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class NMActivateMTD extends QueueByDateReport {
    private final static String reportName = "NM Activate MTD";

    public NMActivateMTD() {
        this.excelDataSheetIndex = 10;
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
