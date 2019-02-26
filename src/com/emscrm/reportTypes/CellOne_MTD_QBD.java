package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;


/**
 * @author JShepherd
 */
public final class CellOne_MTD_QBD extends QueueByDateReport {

    private static final String reportName = "Cellular One MTD";
    private final Map<String, String> monthToDateTableNames = Map.ofEntries(
            entry("CellularOne Customer Care", "CustomerCareMTD"),
            entry("CellularOne Hotline", "HotlineMTD"),
            entry("CellularOne Info Email", "InfoEmailMTD"),
            entry("CellularOne NM Activate", "NMActivateMTD"),
            entry("CellularOne NM Info Email", "NMInfoEmailMTD"),
            entry("CellularOne NM Renew", "NMRenewMTD"),
            entry("CellularOne NM Web Sales Email", "NMWebSalesEmailMTD"),
            entry("CellularOne Prepaid CS", "PrepaidCSMTD"),
            entry("CellularOne Prepaid TS", "PrepaidTSMTD"),
            entry("CellularOne Recertification", "RecertificationMTD"),
            entry("CellularOne Retail CS", "RetailCSMTD"),
            entry("CellularOne Retail Payment", "RetailPaymentMTD"),
            entry("CellularOne Retail TS", "RetailTSMTD"),
            entry("CellularOne Web Orders Email", "WebOrdersEmailMTD")
    );

    public CellOne_MTD_QBD() {
        this.excelDataSheetIndex = 4;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD.xlsx";
    }

    @Override
    protected XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setDate(source);

        List<String> lengthFilteredSource = this.filterByLength(source, 2);

        openWorkbook();

        Set<String> keySet = monthToDateTableNames.keySet();

        for (String item : keySet) {
            String summary = getMatchingLine(lengthFilteredSource, item);
            String cleanedSummary = cleanString(summary);
            composeExcelSheet(cleanedSummary, monthToDateTableNames.get(item));
        }

        System.out.println(wb.toString());
        return wb;
    }

    private void composeExcelSheet(String summary, String tableName) {

        XSSFTable aTable = wb.getTable(tableName);

        int endRowIndex = aTable.getEndRowIndex();

        XSSFSheet sheet = aTable.getXSSFSheet();
        XSSFRow row = sheet.getRow(endRowIndex);

        XSSFWorkbook tempWorkbook = sheet.getWorkbook();
        XSSFRow formattedRow = formatCells(tempWorkbook, row);

        String[] v = summary.split("\t");

        //formattedRow is an out variable
        setValuesToCells(formattedRow, v);

        aTable.updateReferences();

    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
    }

    public Map<String, String> getTableNames() {
        return monthToDateTableNames;
    }

    @Override
    public String getWeeklyReportFilename() {
        return weeklyReportFilename;
    }

    @Override
    public String toString() {
        return reportName;
    }
}

