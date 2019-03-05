package com.emscrm;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.time.LocalDate;

/**
 * @author JShepherd
 */
public abstract class QueueSummaryReport extends Report {

    protected String weeklyReportFilename;

    protected QueueSummaryReport() { }

    @Override
    protected XSSFRow getRow(XSSFSheet sheet, int index) {
        if (isSingleLineTable()) {
            return sheet.getRow(index);
        }
        XSSFRow row = sheet.createRow(index);
        return createCells(row);
    }

    @Override
    protected XSSFRow formatCells(XSSFWorkbook aWorkbook, XSSFRow row) {

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
        row.getCell(2).setCellStyle(wholeNumStyle);
        row.getCell(3).setCellStyle(percentStyle);
        row.getCell(4).setCellStyle(wholeNumStyle);
        row.getCell(5).setCellStyle(percentStyle);

        row.getCell(6).setCellStyle(durationStyle);
        row.getCell(7).setCellStyle(percentStyle);
        row.getCell(8).setCellStyle(durationStyle);
        row.getCell(9).setCellStyle(durationStyle);
        row.getCell(10).setCellStyle(durationStyle);
        row.getCell(11).setCellStyle(durationStyle);
        row.getCell(12).setCellStyle(wholeNumStyle);
        row.getCell(13).setCellStyle(wholeNumStyle);
        row.getCell(14).setCellStyle(wholeNumStyle);
        row.getCell(15).setCellStyle(wholeNumStyle);

        //adjusted abandon percentage
        row.getCell(16).setCellStyle(percentStyle);
        int currentRowIndex = row.getCell(16).getRowIndex() + 1; //Add one because POI is zero based and Excel is one based.
        row.getCell(16).setCellFormula("(E" + currentRowIndex + "-P" + currentRowIndex + ")/B" + currentRowIndex);

        return row;
    }

    @Override
    protected void setValuesToCells(XSSFRow row, String[] v) {
        //row is an out variable
        LocalDate date = getDate();

        row.getCell(0).setCellType(CellType.NUMERIC);
        long daysElapsedFrom1900To1970 = 25569;//
        row.getCell(0).setCellValue(date.toEpochDay() + daysElapsedFrom1900To1970);

        row.getCell(1).setCellValue(Double.parseDouble(v[1]));
        row.getCell(2).setCellValue(Double.parseDouble(v[2]));
        row.getCell(3).setCellValue(Double.parseDouble(v[3]) / 100);
        row.getCell(4).setCellValue(Double.parseDouble(v[4]));
        row.getCell(5).setCellValue(Double.parseDouble(v[5]) / 100);
        row.getCell(6).setCellValue(DurationUtility.toFractionOfDay(v[6]));
        row.getCell(7).setCellValue(Double.parseDouble(v[7]) / 100);
        row.getCell(8).setCellValue(DurationUtility.toFractionOfDay(v[8]));
        row.getCell(9).setCellValue(DurationUtility.toFractionOfDay(v[9]));
        row.getCell(10).setCellValue(DurationUtility.toFractionOfDay(v[10]));
        row.getCell(11).setCellValue(DurationUtility.toFractionOfDay(v[11]));
        row.getCell(12).setCellValue(Double.parseDouble(v[12]));
        row.getCell(13).setCellValue(Double.parseDouble(v[13]));
        row.getCell(14).setCellValue(Double.parseDouble(v[14]));
        row.getCell(15).setCellValue(Double.parseDouble(v[20]));

    }

    @Override
    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }

    @Override
    public int getSourceLineMinimumLength() {
        return 3;
    }

}

