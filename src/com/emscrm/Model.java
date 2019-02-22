package com.emscrm;

import excelops.ExcelOps;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

/**
 * @author JShepherd
 */
class Model {

    private Report report;

    Model(Report aReport) {
        this.report = aReport;
    }

    void runAndWriteReport(List<String> source) throws InvalidFormatException, IOException {
        XSSFWorkbook wb = report.run(source);
        writeWorkbookToFile(wb);
    }

    List<String> readXlsFileToList(String filename) throws InvalidFormatException, IOException {
        ExcelOps excelOps = new ExcelOps();
        HSSFWorkbook wb = (HSSFWorkbook) excelOps.openWorkbook(filename);
        return excelOps.sheetToTabList(wb, 0);
    }

    private void writeWorkbookToFile(XSSFWorkbook wb) {
        System.out.println("In writeWorkbookToFile() method." + " " + this.toString());
        ExcelOps excelOps = new ExcelOps();
        excelOps.writeWorkbook(wb, report.getWeeklyReportFilename());
    }

    Report getReport() {
        return report;
    }

    void setReport(Report aReport) {
        this.report = aReport;
    }

    @Override
    public String toString() {
        return "Model with report: " + report.toString();
    }

}
