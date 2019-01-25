package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class OrbitQBD extends QueueByDateReport {

    private final static String reportName = "Orbit";

    public OrbitQBD() {

        super(new String[]{"Orbit Callback", "Orbit HE Product", "Orbit HE Timer", "Orbit Hydro-Rain",
                        "Orbit Hydro-Rain Manuals", "Orbit Hydro-Rain Other", "Orbit Hydro-Rain Pro", "Orbit Hydro-Rain Pro Callback",
                        "Orbit Iris HE Timer", "Orbit Iris UG Timer", "Orbit Orders", "Orbit Other", "Orbit UG Sprinkler",
                        "Orbit UG Timer"},
                new String[]{"Orbit Cased Email", "Orbit Cased Email 2", "Orbit Email", "Orbit OSSD Email"});
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
