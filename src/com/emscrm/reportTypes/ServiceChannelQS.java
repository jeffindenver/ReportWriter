package com.emscrm.reportTypes;

import com.emscrm.FuzeQueueSummary;

import java.util.Map;

public class ServiceChannelQS extends FuzeQueueSummary {

    public static final String reportName = "Service Channel";

    protected final Map<String, String> tableNames = Map.of("srvchl-badge-support", "BadgeTable2019",
            "srvchl-bloomin-brands", "BBI_Table2019", "srvchl-call-center-regular", "RegularTable2019",
            "srvchl-contractor-support", "ContractorTable2019", "srvchl-ivr", "IVRTable2019",
            "srvchl-queue2", "Queue2Table2019", "srvchl-queue3", "Queue3Table2019");

    public ServiceChannelQS() {
        super.weeklyReportFilename = "s:\\reports\\call Centers\\service channel\\service channel monthly 2019.xlsx";
    }

    @Override
    protected Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    protected String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    protected boolean isSingleLineTable() {
        return false;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
