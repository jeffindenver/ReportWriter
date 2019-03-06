package com.emscrm;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

class ReportStyle {

    XSSFCellStyle wholeNumStyle;
    XSSFCellStyle durationStyle;
    XSSFCellStyle percentStyle;
    XSSFCellStyle monthAndDayStyle;

    ReportStyle(XSSFWorkbook workbook) {
        createStyle(workbook);
    }

    private void createStyle(XSSFWorkbook aWorkbook) {

        XSSFFont bodyFont = aWorkbook.createFont();
        bodyFont.setFontName("Calibri");
        bodyFont.setFontHeightInPoints((short) 9);

        monthAndDayStyle = aWorkbook.createCellStyle();
        XSSFDataFormat monthAndDayFormat = aWorkbook.createDataFormat();
        monthAndDayStyle.setDataFormat(monthAndDayFormat.getFormat("d-mmm-yy"));
        monthAndDayStyle.setAlignment(HorizontalAlignment.CENTER);
        monthAndDayStyle.setFont(bodyFont);

        wholeNumStyle = aWorkbook.createCellStyle();
        XSSFDataFormat wholeNumFormat = aWorkbook.createDataFormat();
        wholeNumStyle.setDataFormat(wholeNumFormat.getFormat("General"));
        wholeNumStyle.setAlignment(HorizontalAlignment.CENTER);
        wholeNumStyle.setFont(bodyFont);

        durationStyle = aWorkbook.createCellStyle();
        XSSFDataFormat timeFormat = aWorkbook.createDataFormat();
        durationStyle.setDataFormat(timeFormat.getFormat("[h]:mm:ss"));
        durationStyle.setAlignment(HorizontalAlignment.CENTER);
        durationStyle.setFont(bodyFont);

        percentStyle = aWorkbook.createCellStyle();
        XSSFDataFormat percentFormat = aWorkbook.createDataFormat();
        percentStyle.setDataFormat(percentFormat.getFormat("0.00%"));
        percentStyle.setAlignment(HorizontalAlignment.CENTER);
        percentStyle.setFont(bodyFont);
    }
}