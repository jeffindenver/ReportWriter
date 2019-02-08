package com.emscrm.reportTypes;

public class HabitatReStoreShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "Habitat ReStore Short Abandons";
    private final int excelDataSheetIndex;

    public HabitatReStoreShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\Habitat for Humanity\\Habitat for Humanity Weekly Stats 2019.xlsx";
        excelDataSheetIndex = 0;
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
