package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

public class ChildrensVillageMonthlyQBD extends QueueByDateReport {

    private final static String reportName = "Childrens Village monthly calls";
    private final Map<String, String> tableNames = Map.of("Grand Total:", "CallsTable");

    public ChildrensVillageMonthlyQBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Childrens Village\\Childrens Village Monthly Report 2020.xlsx";
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
