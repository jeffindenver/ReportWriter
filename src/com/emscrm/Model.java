package com.emscrm;

import excelops.ExcelOps;
import fileops.FileOps;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author JShepherd
 */
public class Model {

    private ReportComposer composer;
    private boolean isEmail;

    Model(ReportComposer aComposer) {
        this.composer = aComposer;
        isEmail = false;
    }

    String runReport(List<String> source) throws InvalidFormatException, IOException{
       return composer.runReport(source);
    }

private ReportComposer getComposer() {
        return composer;
    }

    void setComposer(ReportComposer aFilter) {
        this.composer = aFilter;
    }

    public String getReportName() {
        return this.getComposer().getReportName();
    }

    String getSummary(List<String> list) {
        return this.getComposer().getSummary(list);
    }

    LocalDate getDateFromList(List<String> source) {
        return composer.getDateFromList(source);
    }

    String formatRow(String s) {
        return getComposer().formatCsvRow(s);
    }

    List<String> readXlsFileToList(String filename) throws InvalidFormatException, IOException {
        ExcelOps excelOps = new ExcelOps();
        HSSFWorkbook wb = (HSSFWorkbook) excelOps.openWorkbook(filename);
        return excelOps.sheetToTabList(wb, 0);
    }

    @SuppressWarnings("all")
    void writeSummaryToExcelFile(String summary) throws InvalidFormatException, IOException {
        System.out.println("In writeSummaryToExcelFile() method." + " " + getComposer().toString());
        ExcelOps excelOps = new ExcelOps();

        String filename = composer.getExcelFilepath();

        XSSFWorkbook wb = (XSSFWorkbook) excelOps.openWorkbook(filename);
        XSSFSheet sheet = wb.getSheetAt(getComposer().getDataSheetIndex());

        sheet = composer.composeSheet(sheet, summary);

        excelOps.writeWorkbook(wb, composer.getExcelFilepath());
    }

    void writeListToFile(List<String> list) {
        String filepath = composeFilepath();

        FileOps fo = new FileOps(filepath, true);

        for (String line : list) {
            try {
                fo.writeToFile(line);
                fo.writeToFile("\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getPreviousMonth() {
        final String[] MONTHS = {"Jan", "Feb", "Mar", "April", "May", "June",
                "July", "Aug", "Sept", "Oct", "Nov", "Dec"};

        int month = LocalDate.now().getMonthValue();
        month -= 2;//The report is for the previous month, and getMonthValue() returns 1-12
        if (month < 0 || month > 11) {
            month = 11;
        }
        return MONTHS[month];
    }

    private String getTypeString() {
        String type;
        if (isEmail) {
            type = "Email";
        } else {
            type = "Calls";
        }
        return type;
    }

    private String composeFilepath() {
        StringBuilder sb = new StringBuilder();

        String directory = System.getProperty("user.home");

        sb.append(directory);
        sb.append("\\desktop\\");
        sb.append(getPreviousMonth());
        sb.append(getTypeString());
        sb.append(".csv");

        return sb.toString();
    }

    @Override
    public String toString() {
        return "composer: " + composer.toString() + " isEmail == " + isEmail;
    }


}
