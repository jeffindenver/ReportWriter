package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public class HotlineWTD extends QueueByDateReport {
    private final static String reportName = "Hotline WTD";

    public HotlineWTD() {
        this.excelDataSheetIndex = 7;
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
