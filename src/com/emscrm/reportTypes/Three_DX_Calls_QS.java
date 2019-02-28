package com.emscrm.reportTypes;

import com.emscrm.QueueSummaryReport;

import java.util.Map;

public class Three_DX_Calls_QS extends QueueSummaryReport {

    private static final String reportName = "3Dconnexion";
    private static final Map<String, String> tableNames = Map.of("Summary", "CallsTable");

    public Three_DX_Calls_QS() {
        weeklyReportFilename = "s:\\reports\\call centers\\3D Connexion\\3Dconnexion Weekly Stats 2019 back.xlsx";
    }

    @Override
    protected boolean isSingleLineTable() {
        return false;
    }

    @Override
    protected String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    protected Map<String, String> getTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
