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
import java.util.Set;

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

        openWorkbook();

        Set<String> keySet = getTableNames().keySet();

        for (String tableName : keySet) {
            String summary = getMatchingLine(lengthFilteredSource, tableName);
            composeExcelSheet(summary, getTableNames().get(tableName));
        }
        return wb;
    }

    private void composeExcelSheet(String summary, String tableName) {
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

    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }
}
