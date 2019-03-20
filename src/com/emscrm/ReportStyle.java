package com.emscrm;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

class ReportStyle {

    XSSFCellStyle generalStyle;
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

        generalStyle = aWorkbook.createCellStyle();
        XSSFDataFormat wholeNumFormat = aWorkbook.createDataFormat();
        generalStyle.setDataFormat(wholeNumFormat.getFormat("General"));
        generalStyle.setAlignment(HorizontalAlignment.CENTER);
        generalStyle.setFont(bodyFont);

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