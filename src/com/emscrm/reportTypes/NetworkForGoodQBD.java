package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class NetworkForGoodQBD extends QueueByDateReport {

    private final static String reportName = "NetworkForGood";

    public NetworkForGoodQBD() {
        super(new String[]{"Network For Good Donor", "Network For Good Nonprofit",
                "Network For Good VPN Shared"}, new String[]{"Network For Good Dedicated Email",
                "Network For Good Shared Email"});
        this.excelDataSheetIndex = 0;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Network for Good\\Network for Good Weekly Stats 2019.xlsx";

    }

    @Override
    public String toString() {
        return reportName;
    }
}
