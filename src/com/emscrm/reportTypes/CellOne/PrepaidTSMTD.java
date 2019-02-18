package com.emscrm.reportTypes.CellOne;

import com.emscrm.QueueByDateReport;

public final class PrepaidTSMTD extends QueueByDateReport {
    private final static String reportName = "Prepaid TS MTD";

    public PrepaidTSMTD() {
        this.excelDataSheetIndex = 20;
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
