package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class NewmarkQBD extends QueueByDateReport {

    private final static String reportName = "Newmark";

    public NewmarkQBD() {

        super(new String[]{"NGKF Aetna", "NGKF Aetna VIP", "NGKF Arrow",
                        "NGKF Arrow Int", "NGKF Bytegrid", "NGKF Cigna", "NGKF Columbia University",
                        "NGKF Disaster / Crisis Hotline", "NGKF Los Angeles", "NGKF Main", "NGKF Main Avallon",
                        "NGKF Message", "NGKF Michigan", "NGKF NSN", "NGKF NSN Int", "NGKF Panasonic", "NGKF Phoenix",
                        "NGKF Phoenix-N California", "NGKF Reed Elsevier", "NGKF TIAA-CREF Charlotte Conf Room",
                        "NGKF TIAA-CREF Charlotte Facility Request", "NGKF TIAA-CREF Charlotte Move Request",
                        "NGKF TIAA-CREF Denver Conf Room", "NGKF TIAA-CREF Denver Facility Request",
                        "NGKF TIAA-CREF Denver Move Request", "NGKF TIAA-CREF Field Office Facility Request",
                        "NGKF TIAA-CREF Field Office Conf Room", "NGKF TIAA-CREF Field Office Move Request",
                        "NGKF TIAA-CREF NY Conf Room", "NGKF TIAA-CREF NY Facility Request",
                        "NGKF TIAA-CREF NY Move Request", "NGKF TKNA FM Help Desk", "NGKF TKNA FM Vendor",
                        "NGKF Zurich", "NGKF IT Help Desk"},
                new String[]{"NGKF Aetna Email", "NGKF Approval Email",
                        "NGKF Arrow Email", "NGKF ByteGrid Email", "NGKF Caliber Home Loans Email",
                        "NGKF FM Helpdesk Email", "NGKF GCS Technology Email", "NGKF Main Email",
                        "NGKF Nielsen Research Email", "NGKF Nielsen TS Email", "NGKF Nordstrom Email",
                        "NGKF NSN Email", "NGKF Panasonic Email", "NGKF TIAA-CREF Helpdesk Email",
                        "NGKF TIAA-CREF Email", "NGKF TIAA-CREF Main Email", "NGKF Reed Elsevier Email",
                        "NGKF Zurich Email", "NGKF Cigna Email", "NGKF TK Service Email"});
    }

    @Override
    public String toString() {
        return reportName;
    }
}
