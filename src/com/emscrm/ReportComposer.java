package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

/**
 * @author JShepherd
 */
public class ReportComposer {

    private final Report report;

    ReportComposer(Report report) {
        this.report = report;
    }

    String runReport(List<String> source) throws InvalidFormatException, IOException {
        report.setDate(source);
        String summary = report.getSummary(source);
        writeToExcelFile(summary);
        return summary;
    }

    private void writeToExcelFile(String summary) throws InvalidFormatException, IOException {
        System.out.println("In writeToExcelFile() method." + " " + this.toString());
        ExcelOps excelOps = new ExcelOps();

        String filename = this.getExcelFilepath();

        XSSFWorkbook wb = (XSSFWorkbook) excelOps.openWorkbook(filename);

        XSSFSheet sheet = wb.getSheetAt(this.getDataSheetIndex());

        @SuppressWarnings("unused")
        XSSFSheet composedSheet = composeSheet(sheet, summary);

        excelOps.writeWorkbook(wb, this.getExcelFilepath());
    }

    private Report getReport() {
        return report;
    }

    XSSFSheet composeSheet(XSSFSheet sheet, String summary) {
        return report.composeExcelSheet(sheet, summary);
    }

    int getDataSheetIndex() {
        return this.getReport().getDataSheetIndex();
    }

    String getReportName() {
        return this.getReport().toString();
    }

    String getExcelFilepath() {
        return this.getReport().getWeeklyReportFilename();
    }

    String formatCsvRow(String s) {
        return report.formatCsvRow(s);
    }

    @Override
    public String toString() {
        return "Filtering for report type " + report.toString() + ".";
    }

}
