package com.emscrm;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.time.LocalDate;

/**
 * @author JShepherd
 */
public abstract class QueueSummaryReport extends Report {

    protected String weeklyReportFilename;

    protected QueueSummaryReport() { }

    @Override
    protected XSSFRow formatCells(XSSFWorkbook aWorkbook, XSSFRow row) {

        ReportStyle reportStyle = new ReportStyle(aWorkbook);

        row.getCell(0).setCellStyle(reportStyle.monthAndDayStyle);
        row.getCell(1).setCellStyle(reportStyle.wholeNumStyle);
        row.getCell(2).setCellStyle(reportStyle.wholeNumStyle);
        row.getCell(3).setCellStyle(reportStyle.percentStyle);
        row.getCell(4).setCellStyle(reportStyle.wholeNumStyle);
        row.getCell(5).setCellStyle(reportStyle.percentStyle);
        row.getCell(6).setCellStyle(reportStyle.durationStyle);
        row.getCell(7).setCellStyle(reportStyle.percentStyle);
        row.getCell(8).setCellStyle(reportStyle.durationStyle);
        row.getCell(9).setCellStyle(reportStyle.durationStyle);
        row.getCell(10).setCellStyle(reportStyle.durationStyle);
        row.getCell(11).setCellStyle(reportStyle.durationStyle);
        row.getCell(12).setCellStyle(reportStyle.wholeNumStyle);
        row.getCell(13).setCellStyle(reportStyle.wholeNumStyle);
        row.getCell(14).setCellStyle(reportStyle.wholeNumStyle);
        row.getCell(15).setCellStyle(reportStyle.wholeNumStyle);

        //adjusted abandon percentage
        row.getCell(16).setCellStyle(reportStyle.percentStyle);
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
    protected int getReportLength() {
        return 17;
    }

    @Override
    public int getSourceLineMinimumLength() {
        return 3;
    }

}

