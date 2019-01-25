package com.emscrm.reportTypes;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.time.LocalDate;
import java.util.List;

public class CPaTShortAband extends com.emscrm.ShortAbandonReport {

    private static final String reportName = "CPaT Short Abandons";
    protected int excelDataSheetIndex;
    private int shortAbandons;
    private LocalDate date;
    private final int shortAbandonOutputIndex;

    public CPaTShortAband() {
        weeklyReportFilename = "s:\\reports\\call centers\\cpat\\CPaT Weekly Stats 2019.xlsx";
        excelDataSheetIndex = 0;
        shortAbandonOutputIndex = 13;

    }

    @Override
    public XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary) {
        //not yet implemented
        return null;
    }

    public void setDate(LocalDate aDate) {
        date = aDate;
    }

    public String getSummary(List<String> source) {
        //not yet implemented
        return "";
    }

    @Override
    public String formatCsvRow(String s) {
        return reportName + "," + s;
    }

    public void setShortAbandons(int abandons) {
        shortAbandons = abandons;
    }

    public int getShortAbandons() {
        return shortAbandons;
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    public int getShortAbandonOutputIndex() {
        return shortAbandonOutputIndex;
    }

    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    public String getReportName() {
        return reportName;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
