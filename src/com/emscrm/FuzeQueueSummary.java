package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class FuzeQueueSummary extends Report {

    protected String weeklyReportFilename;

    @Override
    protected XSSFRow formatCells(XSSFWorkbook wb, XSSFRow row) {

        ReportStyle reportStyle = new ReportStyle(wb);

        row.getCell(0).setCellStyle(reportStyle.generalStyle);
        row.getCell(1).setCellStyle(reportStyle.generalStyle);
        row.getCell(2).setCellStyle(reportStyle.generalStyle);
        row.getCell(3).setCellStyle(reportStyle.generalStyle);
        row.getCell(4).setCellStyle(reportStyle.percentStyle);
        row.getCell(5).setCellStyle(reportStyle.percentStyle);
        row.getCell(6).setCellStyle(reportStyle.generalStyle);
        row.getCell(7).setCellStyle(reportStyle.generalStyle);
        row.getCell(8).setCellStyle(reportStyle.generalStyle);
        row.getCell(9).setCellStyle(reportStyle.generalStyle);
        row.getCell(10).setCellStyle(reportStyle.generalStyle);
        row.getCell(11).setCellStyle(reportStyle.generalStyle);
        row.getCell(12).setCellStyle(reportStyle.generalStyle);
        row.getCell(13).setCellStyle(reportStyle.percentStyle);
        row.getCell(14).setCellStyle(reportStyle.percentStyle);
        row.getCell(15).setCellStyle(reportStyle.durationStyle);
        row.getCell(16).setCellStyle(reportStyle.durationStyle);
        row.getCell(17).setCellStyle(reportStyle.durationStyle);
        row.getCell(18).setCellStyle(reportStyle.durationStyle);
        row.getCell(19).setCellStyle(reportStyle.durationStyle);
        row.getCell(20).setCellStyle(reportStyle.durationStyle);
        row.getCell(21).setCellStyle(reportStyle.generalStyle);
        row.getCell(22).setCellStyle(reportStyle.generalStyle);
        row.getCell(23).setCellStyle(reportStyle.generalStyle);
        row.getCell(24).setCellStyle(reportStyle.generalStyle);
        row.getCell(25).setCellStyle(reportStyle.generalStyle);
        row.getCell(26).setCellStyle(reportStyle.generalStyle);

        return row;
    }

    @Override
    protected void setValuesToCells(XSSFRow row, String[] v) {
        //row is an out variable

        //Cell 0 should already be populated with the month
        row.getCell(1).setCellValue(v[1]);
        row.getCell(2).setCellValue(Double.parseDouble(v[2]));
        row.getCell(3).setCellValue(Double.parseDouble(v[3]));
        row.getCell(4).setCellValue(Double.parseDouble(v[4]) / 100);
        row.getCell(5).setCellValue(Double.parseDouble(v[5]) / 100);
        row.getCell(6).setCellValue(Double.parseDouble(v[6]));
        row.getCell(7).setCellValue(Double.parseDouble(v[7]));
        row.getCell(8).setCellValue(Double.parseDouble(v[8]));
        row.getCell(9).setCellValue(Double.parseDouble(v[9]));
        row.getCell(10).setCellValue(Double.parseDouble(v[10]));
        row.getCell(11).setCellValue(Double.parseDouble(v[11]));
        row.getCell(12).setCellValue(Double.parseDouble(v[12]));
        row.getCell(13).setCellValue(Double.parseDouble(v[13]) / 100);
        row.getCell(14).setCellValue(Double.parseDouble(v[14]) / 100);
        row.getCell(15).setCellValue(DurationUtility.toFractionOfDay(v[15]));
        row.getCell(16).setCellValue(DurationUtility.toFractionOfDay(v[16]));
        row.getCell(17).setCellValue(DurationUtility.toFractionOfDay(v[17]));
        row.getCell(18).setCellValue(DurationUtility.toFractionOfDay(v[18]));
        row.getCell(19).setCellValue(DurationUtility.toFractionOfDay(v[19]));
        row.getCell(20).setCellValue(DurationUtility.toFractionOfDay(v[20]));
        row.getCell(21).setCellValue(Double.parseDouble(v[21]));
        row.getCell(22).setCellValue(Double.parseDouble(v[22]));
        row.getCell(23).setCellValue(Double.parseDouble(v[23]));
        row.getCell(24).setCellValue(Double.parseDouble(v[24]));
        row.getCell(25).setCellValue(Double.parseDouble(v[25]));
        row.getCell(26).setCellValue(Double.parseDouble(v[26]));
    }

    @Override
    protected int getReportRowLength() {
        return 26;
    }

    @Override
    protected int getSourceLineMinimumLength() {
        return 2;
    }

    @Override
    protected int getSourceSheetIndex() {
        return 2;
    }

}