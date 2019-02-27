package com.emscrm;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

/**
 * @author JShepherd
 */
public abstract class QueueByDateReport extends Report {

    protected String weeklyReportFilename;

    protected QueueByDateReport() { }

    @Override
    protected void composeExcelSheet(String summary, String tableName) {

        XSSFTable aTable = wb.getTable(tableName);
        System.out.println("Table name is " + aTable.getName());

        int rowIndex = getRowIndex(aTable);

        aTable.setDataRowCount(getRowCount(rowIndex));

        XSSFSheet sheet = aTable.getXSSFSheet();

        XSSFRow row = getRow(sheet, rowIndex);

        XSSFWorkbook tempWorkbook = sheet.getWorkbook();
        XSSFRow formattedRow = formatCells(tempWorkbook, row);

        String[] v = summary.split("\t");

        //formattedRow is an out variable
        setValuesToCells(formattedRow, v);

        aTable.updateReferences();
    }

    private int getRowCount(int rowIndex) {
        if (isSingleLineTable()) {
            return 1;
        } else {
            return rowIndex;
        }
    }

    private XSSFRow getRow(XSSFSheet sheet, int index) {
        if (isSingleLineTable()) {
            return sheet.getRow(index);
        }
        XSSFRow row = sheet.createRow(index);
        return createCells(row);
    }

    private int getRowIndex(XSSFTable aTable) {
        int index = aTable.getEndRowIndex();
        if (isSingleLineTable()) {
            return index;
        }
        return index + 1;
    }

    private XSSFRow createCells(@NotNull XSSFRow row) {

        for (int i = 0; i < ReportConstants.QBD_REPORT_LENGTH; i++) {
            row.createCell(i);
        }
        return row;
    }

    private XSSFRow formatCells(XSSFWorkbook aWorkbook, XSSFRow row) {

        XSSFFont bodyFont = aWorkbook.createFont();
        bodyFont.setFontName("Calibri");
        bodyFont.setFontHeightInPoints((short) 9);

        XSSFCellStyle monthAndDayStyle = aWorkbook.createCellStyle();
        XSSFDataFormat monthAndDayFormat = aWorkbook.createDataFormat();
        monthAndDayStyle.setDataFormat(monthAndDayFormat.getFormat("d-mmm-yy"));
        monthAndDayStyle.setAlignment(HorizontalAlignment.CENTER);
        monthAndDayStyle.setFont(bodyFont);

        XSSFCellStyle wholeNumStyle = aWorkbook.createCellStyle();
        XSSFDataFormat wholeNumFormat = aWorkbook.createDataFormat();
        wholeNumStyle.setDataFormat(wholeNumFormat.getFormat("General"));
        wholeNumStyle.setAlignment(HorizontalAlignment.CENTER);
        wholeNumStyle.setFont(bodyFont);

        XSSFCellStyle durationStyle = aWorkbook.createCellStyle();
        XSSFDataFormat timeFormat = aWorkbook.createDataFormat();
        durationStyle.setDataFormat(timeFormat.getFormat("[h]:mm:ss"));
        durationStyle.setAlignment(HorizontalAlignment.CENTER);
        durationStyle.setFont(bodyFont);

        XSSFCellStyle percentStyle = aWorkbook.createCellStyle();
        XSSFDataFormat percentFormat = aWorkbook.createDataFormat();
        percentStyle.setDataFormat(percentFormat.getFormat("0.00%"));
        percentStyle.setAlignment(HorizontalAlignment.CENTER);
        percentStyle.setFont(bodyFont);

        row.getCell(0).setCellStyle(monthAndDayStyle);
        row.getCell(1).setCellStyle(wholeNumStyle);
        row.getCell(2).setCellStyle(durationStyle);
        row.getCell(3).setCellStyle(durationStyle);
        row.getCell(4).setCellStyle(durationStyle);
        row.getCell(5).setCellStyle(durationStyle);

        row.getCell(6).setCellStyle(wholeNumStyle);
        row.getCell(7).setCellStyle(durationStyle);
        row.getCell(8).setCellStyle(percentStyle);
        row.getCell(9).setCellStyle(durationStyle);
        row.getCell(10).setCellStyle(durationStyle);
        row.getCell(11).setCellStyle(percentStyle);
        row.getCell(12).setCellStyle(wholeNumStyle);
        row.getCell(13).setCellStyle(wholeNumStyle);
        row.getCell(14).setCellStyle(percentStyle);

        int currentRowIndex = row.getCell(12).getRowIndex() + 1; //Add one because POI is zero based and Excel is one based.
        row.getCell(12).setCellFormula("SUM(B" + currentRowIndex + ",G" + currentRowIndex + ")");
        row.getCell(14).setCellFormula("IF(G" + currentRowIndex + "=0,0,IF(M" + currentRowIndex + "=0,0,SUM(G" + currentRowIndex + "-N" + currentRowIndex + ")/M" + currentRowIndex + "))");

        return row;
    }

    private void setValuesToCells(XSSFRow row, String[] v) {
        //row is an out variable
        LocalDate date = getDate();

        row.getCell(0).setCellType(CellType.NUMERIC);
        long daysElapsedFrom1900To1970 = 25569;//
        row.getCell(0).setCellValue(date.toEpochDay() + daysElapsedFrom1900To1970);

        row.getCell(1).setCellValue(Double.parseDouble(v[1]));
        row.getCell(2).setCellValue(DurationUtility.toFractionOfDay(v[2]));
        row.getCell(3).setCellValue(DurationUtility.toFractionOfDay(v[3]));
        row.getCell(4).setCellValue(DurationUtility.toFractionOfDay(v[4]));
        row.getCell(5).setCellValue(DurationUtility.toFractionOfDay(v[5]));
        row.getCell(6).setCellValue(Double.parseDouble(v[6]));
        row.getCell(7).setCellValue(DurationUtility.toFractionOfDay(v[7]));
        row.getCell(8).setCellValue(Double.parseDouble(v[8]) / 100);
        row.getCell(9).setCellValue(DurationUtility.toFractionOfDay(v[9]));
        row.getCell(10).setCellValue(DurationUtility.toFractionOfDay(v[10]));
        row.getCell(11).setCellValue(Double.parseDouble(v[11]) / 100);
    }

    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }

    public int getSourceLineMinimumLength() {
        return 3;
    }

}
