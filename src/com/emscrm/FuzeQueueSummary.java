package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * FuzeQueueSummary is a report type used by the Service Channel workgroup.
 */
public abstract class FuzeQueueSummary extends Report {

    protected String weeklyReportFilename;

    /**
     * FormatCells method sets the style (font, size, colors, etc) of a row
     * and its cells.
     *
     * @param wb  Styles need to be associated with a workbook.
     * @param row The row to be styled.
     * @return returns the row once its component cells are styled.
     */
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
    XSSFRow createNewRowOrGetExistingRow(XSSFSheet sheet, int index) {

        String matchingMonth = getPreviousMonth();
        XSSFTable theTable = sheet.getTables().get(0);

        int startRowIndex = theTable.getStartRowIndex();
        int endRowIndex = theTable.getEndRowIndex();

        XSSFRow row = null;

        for (int i = startRowIndex; i < endRowIndex; i++) {
            if (sheet.getRow(i).getCell(0).getStringCellValue().contains(matchingMonth)) {
                row = sheet.getRow(i);
                break;
            } else {
                row = createCells(sheet.createRow(endRowIndex + 1));
            }
        }

        return row;
    }

    @Override
    protected void setValuesToCells(XSSFRow row, String[] v) {
        //row is an out variable

        System.out.println("Element 15 is " + v[15] + ".");
        double durationAsFraction = DurationUtility.toFractionOfDay(v[15]);
        System.out.println("Duration as fraction is " + durationAsFraction);

        row.getCell(0).setCellValue(getPreviousMonth());
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
        row.getCell(13).setCellValue(Double.parseDouble(v[13]));
        row.getCell(14).setCellValue(Double.parseDouble(v[14]));
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
    }

    private String getPreviousMonth() {
        LocalDate current = LocalDate.now();
        LocalDate lastMonth = current.withMonth(determineLastMonth());
        return lastMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.US);
    }

    private int determineLastMonth() {
        LocalDate current = LocalDate.now();
        int lastMonth = current.getMonthValue() - 1;
        if (lastMonth == 0) {
            lastMonth = 12;
        }
        return lastMonth;
    }

    @Override
    protected int getReportRowLength() {
        return 27;
    }

    @Override
    protected int getSourceLineMinimumLength() {
        return 2;
    }

    @Override
    protected int getSourceSheetIndex() {
        return 1;
    }

}
