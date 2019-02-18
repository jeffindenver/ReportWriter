package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public final class CPaTQBD extends QueueByDateReport {

    private static final String reportName = "CPaT";

    public CPaTQBD() {
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\cpat\\CPaT Weekly Stats 2019.xlsx";
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    public int getDataSheetIndex(){
        return excelDataSheetIndex;
    }

    @Override
    public String toString() {
        return reportName;
    }

}
