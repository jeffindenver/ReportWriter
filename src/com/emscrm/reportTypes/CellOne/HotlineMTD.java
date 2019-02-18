package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class HotlineMTD extends QueueByDateReport {
    private final static String reportName = "Hotline MTD";
    private final static int excelDataSheetIndex = 6;

    public HotlineMTD() {
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
