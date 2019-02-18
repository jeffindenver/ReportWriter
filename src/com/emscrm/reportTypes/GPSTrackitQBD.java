package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public final class GPSTrackitQBD extends QueueByDateReport {

    private final static String reportName = "GPS Trackit";

    public GPSTrackitQBD() {
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Weekly Stats 2019.xlsx";
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
