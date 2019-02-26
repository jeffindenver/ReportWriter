package com.emscrm;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public abstract class ShortAbandonReport extends Report {

    private final int shortAbandIndex;
    protected String weeklyReportFilename;
    private double shortAbandons;
    private XSSFWorkbook wb;

    protected ShortAbandonReport() {
        shortAbandIndex = 13;
        shortAbandons = 0;
        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_ShortAbandonReport.xlsx";
    }

    protected XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setDate(source);

        List<String> lengthFilteredSource = this.filterByLength(source, 1);

        String summary = getMatchingLine(lengthFilteredSource, "Grand Total:");

        openWorkbook();

        XSSFSheet sheet = wb.getSheetAt(this.getDataSheetIndex());

        composeExcelSheet(sheet, summary);

        return wb;
    }

    private void composeExcelSheet(XSSFSheet sheet, String summary) {
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

    }

    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }
}
