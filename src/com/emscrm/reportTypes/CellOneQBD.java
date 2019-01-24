package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class CellOneQBD extends QueueByDateReport {

    private final static String reportName = "Cellular One";
    //what is the index of the data sheet

    public CellOneQBD() {
        //@ToDo add the workgroups for CellOneQBD
        super(new String[]{"none"},
                new String[]{"none"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne Weekly Report.xlsx";
    }

    @Override
    public String getExcelFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }

}
