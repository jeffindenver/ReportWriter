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

    //private ReportComposer composer;
    private Report report;


//    Model(ReportComposer aComposer) {
//        this.composer = aComposer;
//    }

    Model(Report aReport) {
        this.report = aReport;
    }

    void runReport(List<String> source) throws InvalidFormatException, IOException {
       //composer.runAndWriteReport(source);
        XSSFWorkbook wb = report.run(source);
        writeWorkbookToFile(wb);
    }

    void setReport(Report aReport) {
        this.report = aReport;
    }

//    void setComposer(ReportComposer aComposer) {
//        this.composer = aComposer;
//    }

    List<String> readXlsFileToList(String filename) throws InvalidFormatException, IOException {
        ExcelOps excelOps = new ExcelOps();
        HSSFWorkbook wb = (HSSFWorkbook) excelOps.openWorkbook(filename);
        return excelOps.sheetToTabList(wb, 0);
    }

    @SuppressWarnings("all")
    void writeWorkbookToFile(XSSFWorkbook wb) throws InvalidFormatException, IOException {
        System.out.println("In writeWorkbookToFile() method." + " " + this.toString());
        ExcelOps excelOps = new ExcelOps();
        excelOps.writeWorkbook(wb, report.getWeeklyReportFilename());
    }

    Report getReport() {
        return report;
    }

    @Override
    public String toString() {
        return "report: " + report.toString();
    }


}
