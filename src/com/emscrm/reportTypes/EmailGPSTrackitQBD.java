package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class EmailGPSTrackitQBD extends QueueByDateReport {

    private static final String reportName = "GPS Trackit Email";


    public EmailGPSTrackitQBD() {
        super(new String[]{"none"}, new String[]{"none"});
        this.excelDataSheetIndex = 1;
        this.weeklyReportFilename = "s:\\reports\\call centers\\GPS Trackit\\GPS Trackit Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }

}
