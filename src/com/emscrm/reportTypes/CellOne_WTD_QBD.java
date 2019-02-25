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
public final class CellOne_WTD_QBD extends QueueByDateReport {

    private static final String reportName = "Cellular One WTD";
    private Map<String, String> weekToDateTableNames;

    public CellOne_WTD_QBD() {
        this.excelDataSheetIndex = 32;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD Back.xlsx";
        weekToDateTableNames = new HashMap<>();
        weekToDateTableNames.put("CellularOne Customer Care", "CustomerCareWTD");
        weekToDateTableNames.put("CellularOne Hotline", "HotlineWTD");
        weekToDateTableNames.put("CellularOne Info Email", "InfoEmailWTD");
        weekToDateTableNames.put("CellularOne NM Activate", "NMActivateWTD");
        weekToDateTableNames.put("CellularOne NM Info Email", "NMInfoEmailWTD");
        weekToDateTableNames.put("CellularOne NM Renew", "NMRenewWTD");
        weekToDateTableNames.put("CellularOne NM Web Sales Email", "NMWebSalesEmailWTD");
        weekToDateTableNames.put("CellularOne Prepaid CS", "PrepaidCSWTD");
        weekToDateTableNames.put("CellularOne Prepaid TS", "PrepaidTSWTD");
        weekToDateTableNames.put("CellularOne Recertification", "RecertificationWTD");
        weekToDateTableNames.put("CellularOne Retail CS", "RetailCSWTD");
        weekToDateTableNames.put("CellularOne Retail Payment", "RetailPaymentWTD");
        weekToDateTableNames.put("CellularOne Retail TS", "RetailTSWTD");
        weekToDateTableNames.put("CellularOne Web Orders Email", "WebOrdersEmailWTD");

    }

    @Override
    protected XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setDate(source);

        List<String> lengthFilteredSource = this.filterByLength(source, 2);

        openWorkbook();

        Set<String> keySet = weekToDateTableNames.keySet();

        for (String item : keySet) {
            String summary = getMatchingLine(lengthFilteredSource, item);
            String cleanedSummary = cleanString(summary);
            composeExcelSheet(cleanedSummary, weekToDateTableNames.get(item));
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
