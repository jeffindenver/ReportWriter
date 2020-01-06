package com.emscrm.reportTypes;

import com.emscrm.FuzeQueueSummary;

import java.util.Map;

public class ContractorSupportQS extends FuzeQueueSummary {
    public static final String reportName = "SC Contractor monthly";

    private final Map<String, String> tableNames = Map.of("Report Totals", "ContractorTable2019");

    public ContractorSupportQS() {
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
        return "Contractor Support";
    }
}
