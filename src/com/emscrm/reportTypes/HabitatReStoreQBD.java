package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class HabitatReStoreQBD extends QueueByDateReport {

    private final static String reportName = "Habitat Restore";

    public HabitatReStoreQBD() {
        super(new String[]{"Habitat ReStore - Omaha", "Habitat ReStore Chat - Omaha"},
                new String[]{"none"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Habitat for Humanity\\Habitat for Humanity Weekly Stats 2019.xlsx";
    }

    @Override
    public String toString() {
        return reportName;
    }
}
