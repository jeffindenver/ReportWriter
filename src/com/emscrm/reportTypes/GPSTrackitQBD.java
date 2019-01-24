package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class GPSTrackitQBD extends QueueByDateReport {

    private final static String reportName = "GPS Trackit";

    public GPSTrackitQBD() {
        super(new String[]{"GPS Trackit Main", "GPS Trackit TS"},
                new String[]{"GPS Trackit Email"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
