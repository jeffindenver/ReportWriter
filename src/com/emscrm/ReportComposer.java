package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.time.LocalDate;
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
        report.setDate(getDateFromList(source));
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

        sheet = getReport().composeExcelSheet(sheet, summary);

        excelOps.writeWorkbook(wb, this.getExcelFilepath());
    }

    private Report getReport() {
        return report;
    }

    String getSummary(List<String> source) {
        return report.getSummary(source);
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

    LocalDate getDateFromList(List<String> source) {
        int dateIndex = 4;
        String line = source.get(dateIndex);
        String[] values = line.split("\t");
        String[] items = values[1].split(" ");
        String[] tokenizedDate = items[0].split("/");
        int month = Integer.parseInt(tokenizedDate[0]);
        int day = Integer.parseInt(tokenizedDate[1]);
        int year = Integer.parseInt(tokenizedDate[2]);

        return LocalDate.of(year, month, day);
    }

    String formatCsvRow(String s) {
        return report.formatCsvRow(s);
    }

    @Override
    public String toString() {
        return "Filtering for report type " + report.toString() + ".";
    }


}
