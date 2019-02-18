package com.emscrm;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author JShepherd
 */
public abstract class QueueByDateReport extends Report {

    protected int excelDataSheetIndex;
    protected String weeklyReportFilename;
    private XSSFWorkbook wb;

    protected QueueByDateReport() {

        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_QueueByDateReport.xlsx";
    }

    //need javadoc on how to override run() safely.
    protected XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setDate(source);

        String summary = getSummary(source);

        String cleanedSummary = cleanString(summary);

        openWorkbook();

        XSSFSheet sheet = wb.getSheetAt(getDataSheetIndex());

        composeExcelSheet(sheet, cleanedSummary);

        return wb;
    }



    private void composeExcelSheet(XSSFSheet sheet, String summary) {

        List<XSSFTable> tables = sheet.getTables();
        System.out.println("In composeExcelSheet method. Sheet tables contains #" + tables.size());
        //Can also get the table based on the table name
        XSSFTable myTable = tables.get(0);

        int newRowIndex = myTable.getEndRowIndex() + 1;
        myTable.setDataRowCount(newRowIndex);

        XSSFRow row = sheet.createRow(newRowIndex);
        XSSFRow initialRow = createCells(row);

        XSSFWorkbook tempWorkbook = sheet.getWorkbook();
        XSSFRow formattedRow = formatCells(tempWorkbook, initialRow);

        String[] v = summary.split("\t");

        @SuppressWarnings("unused")
        XSSFRow rowWithValues = setValuesToCells(formattedRow, v);

        myTable.updateReferences();

    }

    private XSSFRow createCells(XSSFRow row) {
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

    private XSSFRow setValuesToCells(XSSFRow row, String[] v) {
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

        return row;
    }

    private String cleanString(String summary) {
        System.out.println("Summary line equals " + summary);

        String cleanedSummary = summary.replaceAll("\t:", "\t0:");
        cleanedSummary = cleanedSummary.replaceAll("%", "");
        cleanedSummary = cleanedSummary.replaceAll("\"", "");
        cleanedSummary = cleanedSummary.replaceAll(",", "");

        String[] v = cleanedSummary.split("\t");
        cleanedSummary = excludeLastElement(v);

        System.out.println("Cleaned Summary equals " + cleanedSummary);
        return cleanedSummary;
    }

    private String excludeLastElement(String[] v) {
        StringJoiner joiner = new StringJoiner("\t");
        for (int i = 0; i < v.length - 1; i++) {
            joiner.add(v[i]);
        }
        return joiner.toString();
    }

    protected void setWorkbook(XSSFWorkbook workbook) {
        this.wb = workbook;
    }

}
