package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class CellOneQBD extends QueueByDateReport {

    private final static String reportName = "Cellular One";

    public CellOneQBD() {

        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne Weekly Report.xlsx";
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
