package com.emscrm.reportTypes.ShortAbandons;

import com.emscrm.ShortAbandonReport;

import java.util.Map;

public final class HabitatReStoreShortAband extends ShortAbandonReport {

    private static final String reportName = "Habitat ReStore Short Abandons";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public HabitatReStoreShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Habitat for Humanity\\Habitat for Humanity Weekly Stats 2019.xlsx";
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
    public Map<String, String> getTableNames() {
        return tableNames;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
