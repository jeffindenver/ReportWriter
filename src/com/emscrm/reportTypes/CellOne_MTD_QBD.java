package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author JShepherd
 */
public final class CellOne_MTD_QBD extends QueueByDateReport {

    private static final String reportName = "Cellular One MTD";
    private Map<String, String> monthToDateTableNames;

    public CellOne_MTD_QBD() {
        this.excelDataSheetIndex = 32;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD Back.xlsx";
        monthToDateTableNames = new HashMap<>();
        monthToDateTableNames.put("CellularOne Customer Care", "CustomerCareMTD");
        monthToDateTableNames.put("CellularOne Hotline", "HotlineMTD");
        monthToDateTableNames.put("CellularOne Info Email", "InfoEmailMTD");
        monthToDateTableNames.put("CellularOne NM Activate", "NMActivateMTD");
        monthToDateTableNames.put("CellularOne NM Info Email", "NMInfoEmailMTD");
        monthToDateTableNames.put("CellularOne NM Renew", "NMRenewWTD");
        monthToDateTableNames.put("CellularOne NM Web Sales Email", "NMWebSalesEmailMTD");
        monthToDateTableNames.put("CellularOne Prepaid CS", "PrepaidCSMTD");
        monthToDateTableNames.put("CellularOne Prepaid TS", "PrepaidTSMTD");
        monthToDateTableNames.put("CellularOne Recertification", "RecertificationMTD");
        monthToDateTableNames.put("CellularOne Retail CS", "RetailCSMTD");
        monthToDateTableNames.put("CellularOne Retail Payment", "RetailPaymentMTD");
        monthToDateTableNames.put("CellularOne Retail TS", "RetailTSMTD");
        monthToDateTableNames.put("CellularOne Web Orders Email", "WebOrdersEmailMTD");

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

        int newRowIndex = aTable.getEndRowIndex() + 1;
        aTable.setDataRowCount(newRowIndex);

        XSSFSheet sheet = aTable.getXSSFSheet();
        XSSFRow row = sheet.createRow(newRowIndex);
        XSSFRow initialRow = createCells(row);

        XSSFWorkbook tempWorkbook = sheet.getWorkbook();
        XSSFRow formattedRow = formatCells(tempWorkbook, initialRow);

        String[] v = summary.split("\t");

        //formattedRow is an out variable
        setValuesToCells(formattedRow, v);

        aTable.updateReferences();
    }

    public int getDataSheetIndex() {
        return excelDataSheetIndex;
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

