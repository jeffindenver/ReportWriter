package com.emscrm;

import org.apache.poi.xssf.usermodel.*;

public abstract class ShortAbandonReport extends Report {

    private final int shortAbandIndex;
    protected String weeklyReportFilename;
    private double shortAbandons;

    protected ShortAbandonReport() {
        shortAbandIndex = 13;
        shortAbandons = 0.0;
    }

    @Override
    protected XSSFRow getRow(XSSFSheet sheet, int index) {
            return sheet.getRow(index - 1);
    }

    @Override
    protected void setValuesToCells(XSSFRow row, String[] v) {
        this.shortAbandons = Double.valueOf(v[1]);
        row.getCell(shortAbandIndex).setCellValue(shortAbandons);
    }

    @Override
    public XSSFRow formatCells(XSSFWorkbook wb, XSSFRow row){
        //ShortAbandonReport requires no formatting
        return row;
    }

    @Override
    public int getSourceLineMinimumLength() {
        return 2;
    }

    @Override
    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }
}
