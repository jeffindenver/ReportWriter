package com.emscrm;

import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import java.time.LocalDate;
import java.util.List;

public abstract class ShortAbandonReport extends Report {

    protected String weeklyReportFilename;
    protected int excelDataSheetIndex;
    private int shortAbandIndex;
    private double shortAbandons;
    private static final int datelineIndex = 5;

    protected ShortAbandonReport() {
        shortAbandIndex = 13;
        shortAbandons = 0;
        excelDataSheetIndex = 0;
        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_ShortAbandonReport.xlsx";
    }

    protected String run(List<String> source) {
        setDate(source);
        return getSummary(source);
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


    public LocalDate getDate() {
        return this.date;
    }


}
