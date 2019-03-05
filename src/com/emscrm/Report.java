package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

abstract class Report {

    XSSFWorkbook wb;

    private LocalDate date;

    protected abstract void setWorkbook(XSSFWorkbook workbook);

    protected abstract XSSFRow getRow(XSSFSheet sheet, int index);

    protected abstract Map<String, String> getTableNames();

    protected abstract String getWeeklyReportFilename();

    protected abstract boolean isSingleLineTable();

    protected abstract int getSourceLineMinimumLength();

    protected abstract XSSFRow formatCells(XSSFWorkbook wb, XSSFRow row);

    protected abstract void setValuesToCells(XSSFRow row, String[] v);

    private void composeExcelSheet(String summary, String tableName) {

        XSSFTable aTable = wb.getTable(tableName);

        int rowIndex = getRowIndex(aTable);

        aTable.setDataRowCount(getRowCount(rowIndex));

        XSSFSheet sheet = aTable.getXSSFSheet();

        XSSFRow row = getRow(sheet, rowIndex);

        XSSFWorkbook tempWorkbook = sheet.getWorkbook();
        XSSFRow formattedRow = formatCells(tempWorkbook, row);

        String[] v = summary.split("\t");

        //formattedRow is an out variable
        setValuesToCells(formattedRow, v);

        sheet.setActiveCell(CellAddress.A1);

        aTable.updateReferences();
    }

    private int getRowCount(int rowIndex) {
        if (isSingleLineTable()) {
            return 1;
        } else {
            return rowIndex;
        }
    }

    private int getRowIndex(XSSFTable aTable) {
        int index = aTable.getEndRowIndex();
        if (isSingleLineTable()) {
            return index;
        }
        return index + 1;
    }

    XSSFRow createCells(@NotNull XSSFRow row) {
        for (int i = 0; i < ReportConstants.QBD_REPORT_LENGTH; i++) {
            row.createCell(i);
        }
        return row;
    }

    LocalDate getDate() {
        return this.date;
    }

    private void setDate(List<String> source) {
        DateParser dp = new DateParser();

        Optional<String> dateline = getDatelineFromList(dp, source);
        System.out.println(dateline.orElse("Report Class: dateline is empty."));
        Optional<LocalDate> theDate = dateline.map(dp::parseDate);
        this.date = theDate.orElse(LocalDate.MIN);
    }

    XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setDate(source);

        List<String> lengthFilteredSource = filterByLength(source, getSourceLineMinimumLength());

        openWorkbook();

        Set<String> keySet = getTableNames().keySet();

        for (String tableName : keySet) {
            String summary = getMatchingLine(lengthFilteredSource, tableName);
            String cleanedSummary = cleanString(summary);
            composeExcelSheet(cleanedSummary, getTableNames().get(tableName));
        }

        return wb;
    }

    private Optional<String> getDatelineFromList(DateParser dp, List<String> source) {
        return source.stream()
                .filter(dp::containsDate)
                .findFirst();
    }

    private List<String> filterByLength(List<String> list, int minLength) {
        return new ListFilter().filterByLength(minLength, list, "\t");
    }

    String getMatchingLine(List<String> source, String matcher) {
        Optional<String> matchedLine = source.stream()
                .filter(s -> s.contains(matcher))
                .findFirst();
        return matchedLine.orElse("");
    }

    void openWorkbook() throws InvalidFormatException, IOException {
        System.out.println("In openWorkbook() method." + " " + this.toString());
        ExcelOps excelOps = new ExcelOps();
        XSSFWorkbook workbook = (XSSFWorkbook) excelOps.openWorkbook(getWeeklyReportFilename());
        setWorkbook(workbook);
    }

    private String cleanString(String summary) {
        System.out.println("Summary line equals " + summary);

        String cleanedSummary = summary.replaceAll("\t:", "\t0:");
        cleanedSummary = cleanedSummary.replaceAll("%", "");
        cleanedSummary = cleanedSummary.replaceAll("\"", "");
        cleanedSummary = cleanedSummary.replaceAll(",", "");

        String[] v = cleanedSummary.split("\t");
        cleanedSummary = excludeLastElement(v);

        System.out.println("Cleaned Summary equals " + cleanedSummary);
        return cleanedSummary;
    }

    private String excludeLastElement(String[] v) {
        StringJoiner joiner = new StringJoiner("\t");
        for (int i = 0; i < v.length - 1; i++) {
            joiner.add(v[i]);
        }
        return joiner.toString();
    }
}
