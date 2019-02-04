package com.emscrm;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

import static com.emscrm.ReportConstants.*;

/**
 * @author JShepherd
 */
public abstract class QueueByDateReport extends Report {

    protected int excelDataSheetIndex;
    protected String weeklyReportFilename;


    public QueueByDateReport() {

        excelDataSheetIndex = 0;

        weeklyReportFilename = System.getProperty("user.home")
                + "\\desktop\\"
                + LocalDate.now().toString()
                + "_QueueByDateReport.xlsx";
    }

    protected String run(List<String> source) {
        setDate(source);
        String summary = getSummary(source);
        return cleanString(summary);
    }

    public XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary) {

        List<XSSFTable> tables = sheet.getTables();
        System.out.println("In composeExcelSheet method. Sheet tables contains #" + tables.size());
        XSSFTable myTable = tables.get(0);

        int newRowIndex = myTable.getEndRowIndex() + 1;
        myTable.setDataRowCount(newRowIndex);

        XSSFRow row = sheet.createRow(newRowIndex);
        XSSFRow initialRow = createCells(row);

        XSSFWorkbook wb = sheet.getWorkbook();
        XSSFRow formattedRow = formatCells(wb, initialRow);

        String[] v = summary.split("\t");

        @SuppressWarnings("unused")//it is used thank you very much
                XSSFRow rowWithValues = setValuesToCells(formattedRow, v);

        myTable.updateReferences();

        return sheet;
    }

    private XSSFRow createCells(XSSFRow row) {
        for (int i = 0; i < ReportConstants.QBD_REPORT_LENGTH; i++) {
            row.createCell(i);
        }
        return row;
    }

    private XSSFRow formatCells(XSSFWorkbook wb, XSSFRow row) {
        //make a method in the report, and call it from here.
        XSSFFont bodyFont = wb.createFont();
        bodyFont.setFontName("Calibri");
        bodyFont.setFontHeightInPoints((short) 9);

        XSSFCellStyle monthAndDayStyle = wb.createCellStyle();
        XSSFDataFormat monthAndDayFormat = wb.createDataFormat();
        monthAndDayStyle.setDataFormat(monthAndDayFormat.getFormat("d-mmm-yy"));
        monthAndDayStyle.setAlignment(HorizontalAlignment.CENTER);
        monthAndDayStyle.setFont(bodyFont);

        XSSFCellStyle wholeNumStyle = wb.createCellStyle();
        XSSFDataFormat wholeNumFormat = wb.createDataFormat();
        wholeNumStyle.setDataFormat(wholeNumFormat.getFormat("General"));
        wholeNumStyle.setAlignment(HorizontalAlignment.CENTER);
        wholeNumStyle.setFont(bodyFont);

        XSSFCellStyle durationStyle = wb.createCellStyle();
        XSSFDataFormat timeFormat = wb.createDataFormat();
        durationStyle.setDataFormat(timeFormat.getFormat("[h]:mm:ss"));
        durationStyle.setAlignment(HorizontalAlignment.CENTER);
        durationStyle.setFont(bodyFont);

        XSSFCellStyle percentStyle = wb.createCellStyle();
        XSSFDataFormat percentFormat = wb.createDataFormat();
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
        //the number of days passed since 1900-Jan-0
        long daysElapsedFrom1900To1970 = 25569;//
        row.getCell(0).setCellValue(date.toEpochDay() + daysElapsedFrom1900To1970);

        row.getCell(1).setCellValue(Double.parseDouble(v[1]));
        row.getCell(2).setCellValue(toFractionOfDay(v[2]));
        row.getCell(3).setCellValue(toFractionOfDay(v[3]));
        row.getCell(4).setCellValue(toFractionOfDay(v[4]));
        row.getCell(5).setCellValue(toFractionOfDay(v[5]));
        row.getCell(6).setCellValue(Double.parseDouble(v[6]));
        row.getCell(7).setCellValue(toFractionOfDay(v[7]));
        row.getCell(8).setCellValue(Double.parseDouble(v[8]) / 100);
        row.getCell(9).setCellValue(toFractionOfDay(v[9]));
        row.getCell(10).setCellValue(toFractionOfDay(v[10]));
        row.getCell(11).setCellValue(Double.parseDouble(v[11]) / 100);

        return row;
    }

    private double toFractionOfDay(String duration) {
        System.out.println("In method toFractionOfDay. Duration equals " + duration);
        String[] v = duration.split(":");
        Duration someTime = Duration.ZERO;
        someTime = someTime.plusHours(Long.parseLong(v[0]));
        someTime = someTime.plusMinutes(Long.parseLong(v[1]));
        someTime = someTime.plusSeconds(Long.parseLong(v[2]));

        double totalTime = someTime.toMillis() / 1000.0;

        //Excel represents time as a fraction. 0.25 is six hours or 6:00 AM
        int secondsInADay = 86400;
        return totalTime / secondsInADay;
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

    public String formatCsvRow(String row) {
        System.out.println("Starting string is : " + row);
        StringJoiner joiner = new StringJoiner(",");
        String[] reportCategories = row.split("\t");

        double percentAban = Double.valueOf(reportCategories[PERCENT_ABAN]) / 100; //move decimal 2 places to accommodate Excel
        double serviceLevel = Double.valueOf(reportCategories[SVC_LVL]) / 100;

        joiner.add(reportCategories[ACCOUNT_NAME]);
        joiner.add(reportCategories[GROUP_NAME]);
        joiner.add(reportCategories[INTERACTIONS_ANSWERED]);
        joiner.add(reportCategories[AVG_TALK_TIME]);
        joiner.add(reportCategories[TOTAL_TALK_TIME]);
        joiner.add(reportCategories[AVG_ACW]);
        joiner.add(reportCategories[TOTAL_ACW]);
        joiner.add(reportCategories[INTERACTIONS_ABANDONED]);
        joiner.add(reportCategories[AVG_ABAND_DELAY]);
        joiner.add(Double.toString(percentAban));
        joiner.add(reportCategories[MAX_WAIT]);
        joiner.add(reportCategories[ASA]);
        joiner.add(Double.toString(serviceLevel));

        System.out.println("Ending string: " + joiner.toString());
        return joiner.toString();
    }

}
