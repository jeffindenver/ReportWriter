package com.emscrm;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

abstract class Report {

    LocalDate date;

    protected abstract XSSFSheet composeExcelSheet(XSSFSheet sheet, String summary);

    protected abstract String formatCsvRow(String s);

    LocalDate getDate() {
        return this.date;
    }

    protected abstract String getReportName();

    protected abstract int getDataSheetIndex();

    protected abstract String getWeeklyReportFilename();

    protected abstract String run(List<String> source);

    void setDate(List<String> source) {
        DateParser dp = new DateParser();

        Optional<String> dateline = getDatelineFromList(dp, source);
        System.out.println(dateline.orElse("Report line 33: dateline is empty."));
        Optional<LocalDate> theDate = dateline.map(dp::parseDate);
        this.date = theDate.orElse(LocalDate.MIN);
    }

    private Optional<String> getDatelineFromList(DateParser dp, List<String> source) {
        return source.stream()
                .filter(dp::containsDate)
                .findFirst();
    }

    String getSummary(List<String> source) {

        Optional<String> summary = source.stream()
                .filter(s -> s.contains("Grand Total:"))
                .findFirst();
        return summary.orElse("");

    }

}
