package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class PrepaidCSWTD extends QueueByDateReport {
    private final static String reportName = "Prepaid CS MTD";

    public PrepaidCSWTD() {
        this.excelDataSheetIndex = 19;
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
