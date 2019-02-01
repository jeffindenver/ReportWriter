package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;
import java.util.Optional;

abstract class Report {

    abstract String run(List<String> source);

    abstract String getReportName();

    abstract XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary);

    abstract int getDataSheetIndex();

    abstract String getWeeklyReportFilename();

    abstract void setDate(List<String> source);

    abstract String formatCsvRow(String s);

    Optional<String> getSummary(List<String> source) {

        return source.stream()
                .filter(s -> s.contains("Grand Total:"))
                .findFirst();

    }


}
