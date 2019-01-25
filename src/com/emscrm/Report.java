package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.time.LocalDate;
import java.util.List;

interface Report {

   String run();

    String getReportName();
    XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary);
    int getDataSheetIndex();
    String getWeeklyReportFilename();
    void setDate(LocalDate date);
    String getSummary(List<String> source);
    String formatCsvRow(String s);


}
