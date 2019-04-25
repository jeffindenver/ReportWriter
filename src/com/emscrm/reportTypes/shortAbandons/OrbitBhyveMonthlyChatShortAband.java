package com.emscrm.reportTypes.shortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public class OrbitBhyveMonthlyChatShortAband extends ShortAbandonReport {
    private static final String reportName = "Orbit Bhyve monthly calls short abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "ChatTable");

    public OrbitBhyveMonthlyChatShortAband() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Orbit\\B-hyve Call Statistics FY 2017-2019.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return false;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public Map<String, String> getTargetTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
