package com.emscrm.reportTypes;

import com.emscrm.FuzeQueueSummary;

import java.util.Map;

public class ServiceChannelQS extends FuzeQueueSummary {

    private static final String reportName = "Service Channel";

    private final Map<String, String> tableNames = Map.of("srvchl-badge-support", "BadgeTable2020",
            "srvchl-bloomin-brands", "BBI_Table2020", "srvchl-call-center-regular", "RegularTable2020",
            "srvchl-contractor-support", "ContractorTable2020", "srvchl-ivr", "IVRTable2020",
            "srvchl-queue2", "Queue2Table2020", "srvchl-queue3", "Queue3Table2020");

    public ServiceChannelQS() {
        super.weeklyReportFilename = "s:\\reports\\call Centers\\service channel\\service channel monthly 2020.xlsx";
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
