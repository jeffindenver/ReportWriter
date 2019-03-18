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
    protected XSSFRow createNewRowOrGetExistingRow(XSSFSheet sheet, int index) {
        return sheet.getRow(index);
    }

    @Override
    protected int incrementRowIndexOrNot(XSSFTable aTable) {
        return aTable.getEndRowIndex();
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
    protected int getReportRowLength() {
        return 1;
    }

    @Override
    public int getSourceLineMinimumLength() {
        return 2;
    }

}
