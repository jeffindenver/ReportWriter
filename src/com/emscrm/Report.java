package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

abstract class Report {

    protected LocalDate date;

    protected abstract XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary);

    protected abstract String formatCsvRow(String s);

    protected LocalDate getDate() {
        return this.date;
    }

    protected abstract String getReportName();

    protected abstract int getDataSheetIndex();

    protected abstract String getWeeklyReportFilename();

    protected abstract String run(List<String> source);

    private Optional<String> getDateFromList(DateParser dp, List<String> source) {
        return source.stream()
                .filter(dp::containsDate)
                .findFirst();
    }

    protected void setDate(List<String> source) {
        DateParser dp = new DateParser("(d+)/(d+)/(dddd)");

        Optional<String> dateline = getDateFromList(dp, source);
        Optional<LocalDate> theDate = dateline.map(dp::parseDate);
        this.date = theDate.orElse(LocalDate.MIN);
    }

    String getSummary(List<String> source) {

        Optional<String> summary = source.stream()
                .filter(s -> s.contains("Grand Total:"))
                .findFirst();
        return summary.orElse("");

    }


}
