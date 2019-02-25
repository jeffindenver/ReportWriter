package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

abstract class Report {

    private LocalDate date;

    protected abstract void setWorkbook(XSSFWorkbook workbook);

    protected abstract int getDataSheetIndex();

    protected abstract String getWeeklyReportFilename();

    protected abstract XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException;

    LocalDate getDate() {
        return this.date;
    }

    protected void setDate(List<String> source) {
        DateParser dp = new DateParser();

        Optional<String> dateline = getDatelineFromList(dp, source);
        System.out.println(dateline.orElse("Report Class: dateline is empty."));
        Optional<LocalDate> theDate = dateline.map(dp::parseDate);
        this.date = theDate.orElse(LocalDate.MIN);
    }

    private Optional<String> getDatelineFromList(DateParser dp, List<String> source) {
        return source.stream()
                .filter(dp::containsDate)
                .findFirst();
    }

    protected List<String> filterByLength(List<String> list, int minLength) {
        return new ListFilter().filterByLength(minLength, list, "\t");
    }

    protected String getMatchingLine(List<String> source, String matcher) {
        Optional<String> matchedLine = source.stream()
                .filter(s -> s.contains(matcher))
                .findFirst();
        return matchedLine.orElse("");
    }

    protected void openWorkbook() throws InvalidFormatException, IOException {
        System.out.println("In openWorkbook() method." + " " + this.toString());
        ExcelOps excelOps = new ExcelOps();
        XSSFWorkbook workbook = (XSSFWorkbook) excelOps.openWorkbook(getWeeklyReportFilename());
        setWorkbook(workbook);
    }

     void refreshFormulaCell(XSSFRow row, int index) {

        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator(row.getSheet().getWorkbook());

        evaluator.notifyUpdateCell(row.getCell(index));

        int formulaCellIndex = index + 1;

        evaluator.notifySetFormula(row.getCell(formulaCellIndex));

        evaluator.evaluateFormulaCell(row.getCell(formulaCellIndex));
    }
}
