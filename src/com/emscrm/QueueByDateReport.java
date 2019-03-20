package com.emscrm;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;


import java.time.LocalDate;

/**
 * @author JShepherd
 */
public abstract class QueueByDateReport extends Report {

    protected String weeklyReportFilename;

    protected QueueByDateReport() { }

    @Override
    protected XSSFRow formatCells(XSSFWorkbook aWorkbook, XSSFRow row) {

        ReportStyle reportStyle = new ReportStyle(aWorkbook);

        row.getCell(0).setCellStyle(reportStyle.monthAndDayStyle);
        row.getCell(1).setCellStyle(reportStyle.generalStyle);
        row.getCell(2).setCellStyle(reportStyle.durationStyle);
        row.getCell(3).setCellStyle(reportStyle.durationStyle);
        row.getCell(4).setCellStyle(reportStyle.durationStyle);
        row.getCell(5).setCellStyle(reportStyle.durationStyle);
        row.getCell(6).setCellStyle(reportStyle.generalStyle);
        row.getCell(7).setCellStyle(reportStyle.durationStyle);
        row.getCell(8).setCellStyle(reportStyle.percentStyle);
        row.getCell(9).setCellStyle(reportStyle.durationStyle);
        row.getCell(10).setCellStyle(reportStyle.durationStyle);
        row.getCell(11).setCellStyle(reportStyle.percentStyle);
        row.getCell(12).setCellStyle(reportStyle.generalStyle);
        row.getCell(13).setCellStyle(reportStyle.generalStyle);
        row.getCell(14).setCellStyle(reportStyle.percentStyle);

        int currentRowIndex = row.getCell(12).getRowIndex() + 1; //Add one because POI is zero based and Excel is one based.
        row.getCell(12).setCellFormula("SUM(B" + currentRowIndex + ",G" + currentRowIndex + ")");
        row.getCell(14).setCellFormula("IF(G" + currentRowIndex + "=0,0,IF(M" + currentRowIndex + "=0,0,SUM(G" + currentRowIndex + "-N" + currentRowIndex + ")/M" + currentRowIndex + "))");

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

    @Override
    protected int getReportRowLength() {
        return 15;
    }

    @Override
    public int getSourceLineMinimumLength() {
        return 3;
    }

    @Override
    protected int getSourceSheetIndex() {
        return 1;
    }

}
