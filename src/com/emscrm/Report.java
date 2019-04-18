package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

abstract class Report {

    private XSSFWorkbook wb;

    private LocalDate date;

    protected abstract XSSFRow formatCells(XSSFWorkbook wb, XSSFRow row);

    protected abstract int getReportRowLength();

    protected abstract int getSourceLineMinimumLength();

    protected abstract int getSourceSheetIndex();

    protected abstract Map<String, String> getTargetTableNames();

    protected abstract String getWeeklyReportFilename();

    protected abstract boolean isSingleLineTable();

    protected abstract void setValuesToCells(XSSFRow row, String[] v);

    XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setReportDate(source);

        List<String> lengthFilteredSource = filterByLength(source, getSourceLineMinimumLength());

        setTargetWorkbook(readWorkbookFile());

        Set<String> keySet = getTargetTableNames().keySet();

        for (String tableName : keySet) {
            String summary = getMatchingLine(lengthFilteredSource, tableName);

            if (summary.equals("No matched lines")) {
                continue;
            }

            String cleanedSummary = cleanAndFormat(summary);
            composeExcelSheet(cleanedSummary, getTargetTableNames().get(tableName));
        }
        return wb;
    }

    private void setReportDate(List<String> source) {
        DateParser dp = new DateParser();
        Optional<String> dateline = getDatelineFromList(dp, source);
        Optional<LocalDate> theDate = dateline.map(dp::parseDate);
        this.date = theDate.orElse(LocalDate.now());
    }

    private Optional<String> getDatelineFromList(DateParser dp, List<String> source) {
        return source.stream()
                .filter(dp::containsDate)
                .findFirst();
    }

    private List<String> filterByLength(List<String> list, int minLength) {
        return new ListFilter().filterByLength(minLength, list, "\t");
    }

    private void setTargetWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }

    XSSFWorkbook readWorkbookFile() throws InvalidFormatException, IOException {
        ExcelOps excelOps = new ExcelOps();
        return (XSSFWorkbook) excelOps.openWorkbook(getWeeklyReportFilename());
    }

    String getMatchingLine(List<String> source, String matcher) {
        Optional<String> matchedLine = source.stream()
                .filter(s -> s.contains(matcher))
                .findFirst();
        return matchedLine.orElse("No matched lines");
    }

    private String cleanAndFormat(String summary) {
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

    private void composeExcelSheet(String summary, String tableName) {

        XSSFTable aTable = wb.getTable(tableName);

        int rowIndex = incrementRowIndexOrNot(aTable);

        aTable.setDataRowCount(isSingleLineTable() ? 1 : rowIndex);

        XSSFSheet sheet = aTable.getXSSFSheet();

        XSSFRow row = createNewRowOrGetExistingRow(sheet, rowIndex);

        XSSFRow formattedRow = formatCells(wb, row);

        String[] v = summary.split("\t");

        //formattedRow is an out variable
        setValuesToCells(formattedRow, v);

        sheet.setActiveCell(CellAddress.A1);

        aTable.updateReferences();
    }

    private String excludeLastElement(String[] v) {
        StringJoiner joiner = new StringJoiner("\t");
        for (int i = 0; i < v.length - 1; i++) {
            joiner.add(v[i]);
        }
        return joiner.toString();
    }

    XSSFRow createNewRowOrGetExistingRow(XSSFSheet sheet, int index) {
        if (isSingleLineTable()) {
            return sheet.getRow(index);
        }
        XSSFRow row = sheet.createRow(index);
        return createCells(row);
    }

    int incrementRowIndexOrNot(XSSFTable aTable) {
        int index = aTable.getEndRowIndex();
        if (isSingleLineTable()) {
            return index;
        }
        return index + 1;
    }

    XSSFRow createCells(@NotNull XSSFRow row) {
        for (int i = 0; i < getReportRowLength(); i++) {
            row.createCell(i);
        }
        return row;
    }

    LocalDate getDate() {
        return this.date;
    }


}
