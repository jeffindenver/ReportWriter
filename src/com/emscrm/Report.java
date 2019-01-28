package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;

interface Report {

    String getReportName();
    XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary);
    int getDataSheetIndex();
    String getWeeklyReportFilename();
    void setDate(List<String> source);
    String getSummary(List<String> source);
    String formatCsvRow(String s);


}
