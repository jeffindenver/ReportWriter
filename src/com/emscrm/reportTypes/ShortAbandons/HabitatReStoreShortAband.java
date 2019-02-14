package com.emscrm.reportTypes.ShortAbandons;

public class HabitatReStoreShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Habitat ReStore Short Abandons";
    private static final int excelDataSheetIndex = 0;

    public HabitatReStoreShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Habitat for Humanity\\Habitat for Humanity Weekly Stats 2019.xlsx";
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
