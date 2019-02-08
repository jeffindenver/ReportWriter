package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

/**
 * @author JShepherd
 */
class Model {

    private ReportComposer composer;
    private final boolean isEmail;

    Model(ReportComposer aComposer) {
        this.composer = aComposer;
        isEmail = false;
    }

    void runReport(List<String> source) throws InvalidFormatException, IOException {
       composer.runAndWriteReport(source);
    }

    void setComposer(ReportComposer aComposer) {
        this.composer = aComposer;
    }

    List<String> readXlsFileToList(String filename) throws InvalidFormatException, IOException {
        ExcelOps excelOps = new ExcelOps();
        HSSFWorkbook wb = (HSSFWorkbook) excelOps.openWorkbook(filename);
        return excelOps.sheetToTabList(wb, 0);
    }

    @SuppressWarnings("all")
    void writeSummaryToExcelFile(String summary) throws InvalidFormatException, IOException {
        System.out.println("In writeSummaryToExcelFile() method." + " " + composer.toString());
        ExcelOps excelOps = new ExcelOps();

        String filename = composer.getExcelFilepath();

        XSSFWorkbook wb = (XSSFWorkbook) excelOps.openWorkbook(filename);
        XSSFSheet sheet = wb.getSheetAt(composer.getDataSheetIndex());

        sheet = composer.composeSheet(sheet, summary);

        excelOps.writeWorkbook(wb, composer.getExcelFilepath());
    }

    @Override
    public String toString() {
        return "composer: " + composer.toString() + " isEmail == " + isEmail;
    }


}
