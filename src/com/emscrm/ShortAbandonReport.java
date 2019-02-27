package com.emscrm;

import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDate;

public abstract class ShortAbandonReport extends Report {

    private final int shortAbandIndex;
    protected String weeklyReportFilename;
    private double shortAbandons;

    protected ShortAbandonReport() {
        shortAbandIndex = 13;
        shortAbandons = 0;
        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_ShortAbandonReport.xlsx";
    }

    protected void composeExcelSheet(String summary, String tableName) {
        XSSFTable aTable = wb.getTable(tableName);

        int lastRowIndex = aTable.getEndRowIndex();

        XSSFSheet sheet = aTable.getXSSFSheet();
        XSSFRow row = sheet.getRow(lastRowIndex);

        String[] v = summary.split("\t");
        this.shortAbandons = Double.valueOf(v[1]);

        row.getCell(shortAbandIndex).setCellValue(shortAbandons);

        aTable.updateReferences();

        refreshFormulaCell(row, shortAbandIndex);

        sheet.setActiveCell(CellAddress.A1);
    }

    public int getSourceLineMinimumLength() {
        return 2;
    }

    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }
}
