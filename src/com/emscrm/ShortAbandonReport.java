package com.emscrm;

import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public abstract class ShortAbandonReport extends Report {

    protected String weeklyReportFilename;
    protected int excelDataSheetIndex;
    private int shortAbandIndex;
    private double shortAbandons;
    private LocalDate date;
    protected ShortAbandonReport() {
        shortAbandIndex = 13;
        shortAbandons = 0;
        excelDataSheetIndex = 0;
        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_ShortAbandonReport.xlsx";
    }

    public abstract String getWeeklyReportFilename();

    String run(List<String> source) {
        setDate(source);
        Optional<String> summary = getSummary(source);
        return summary.orElse("");
    }

    @Override
    public XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary) {
        List<XSSFTable> tables = sheet.getTables();
        XSSFTable myTable = tables.get(0);

        int lastRowIndex = myTable.getEndRowIndex();
        XSSFRow row = sheet.getRow(lastRowIndex);

        String[] v = summary.split("\t");
        this.shortAbandons = Double.valueOf(v[1]);

        row.getCell(shortAbandIndex).setCellValue(shortAbandons);

        myTable.updateReferences();

        refreshFormulaCell(row, shortAbandIndex);

        sheet.setActiveCell(CellAddress.A1);

        return sheet;
    }

    private void refreshFormulaCell(XSSFRow row, int shortAbandCellIndex) {
        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator(row.getSheet().getWorkbook());
        evaluator.notifyUpdateCell(row.getCell(shortAbandCellIndex));
        int formulaCellIndex = shortAbandCellIndex + 1;
        evaluator.notifySetFormula(row.getCell(formulaCellIndex));
        evaluator.evaluateFormulaCell(row.getCell(formulaCellIndex));
    }

    private LocalDate getDate() {
        return this.date;
    }

    public void setDate(List<String> source) {
        int dateIndex = 5;

        String line = source.get(dateIndex);

        System.out.println("This is the date line: " + line);

        String[] items = line.split(" ");
        String[] tokenizedDate = items[0].split("/");
        int month = Integer.parseInt(tokenizedDate[0]);
        int day = Integer.parseInt(tokenizedDate[1]);
        int year = Integer.parseInt(tokenizedDate[2]);

        this.date = LocalDate.of(year, month, day);
    }

}
