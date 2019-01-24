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

    private ReportComposer filter;
    private boolean isEmail;

    Model(ReportComposer filter) {
        this.filter = filter;
        isEmail = false;
    }

    ReportComposer getFilter() {
        return filter;
    }

    void setFilter(ReportComposer aFilter) {
        this.filter = aFilter;
    }

    public String getReportName() {
        return this.getFilter().getReportName();
    }

    String getSummary(List<String> list) {
        return this.getFilter().getSummary(list);
    }

    LocalDate getDateFromList(List<String> source) {
        return filter.getDateFromList(source);
    }

    String formatRow(String s) {
        return getFilter().formatCsvRow(s);
    }

    String cleanString(String line) {
        return filter.cleanString(line);
    }

    List<String> readXlsFileToList(String filename) throws InvalidFormatException, IOException {
        ExcelOps excelOps = new ExcelOps();
        HSSFWorkbook wb = (HSSFWorkbook) excelOps.openWorkbook(filename);
        return excelOps.sheetToTabList(wb, 0);
    }

    @SuppressWarnings("all")
    void writeSummaryToExcelFile(String summary) throws InvalidFormatException, IOException {
        System.out.println("In writeSummaryToExcelFile() method." + " " + getFilter().toString());
        ExcelOps excelOps = new ExcelOps();

        String filename = filter.getExcelFilepath();

        XSSFWorkbook wb = (XSSFWorkbook) excelOps.openWorkbook(filename);
        XSSFSheet sheet = wb.getSheetAt(getFilter().getDataSheetIndex());

        sheet = filter.composeExcelSheet(sheet, summary);

        excelOps.writeWorkbook(wb, filter.getExcelFilepath());
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
        return "filter: " + filter.toString() + " isEmail == " + isEmail;
    }

}
