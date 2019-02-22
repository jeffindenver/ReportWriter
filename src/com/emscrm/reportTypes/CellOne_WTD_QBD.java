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

    private static final String reportName = "Cellular One";
    private Map<String, String> wtdMap;

    public CellOne_WTD_QBD() {
        this.excelDataSheetIndex = 32;
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD.xlsx";
        wtdMap = new HashMap<>();
        wtdMap.put("CellularOne Customer Care", "CustomerCareWTD");
        wtdMap.put("CellularOne Hotline", "HotlineWTD");
        wtdMap.put("CellularOne Info Email", "InfoEmailWTD");
        wtdMap.put("CellularOne NM Activate", "NMActivateWTD");
        wtdMap.put("CellularOne NM Info Email", "NMInfoEmailWTD");
        wtdMap.put("CellularOne NM Renew", "NMRenewWTD");
        wtdMap.put("CellularOne NM Web Sales Email", "NMWebSalesEmailWTD");
        wtdMap.put("CellularOne Prepaid CS", "PrepaidCSWTD");
        wtdMap.put("CellularOne Prepaid TS", "PrepaidTSWTD");
        wtdMap.put("CellularOne Recertification", "RecertificationWTD");
        wtdMap.put("CellularOne Retail CS", "RetailCSWTD");
        wtdMap.put("CellularOne Retail Payment", "RetailPaymentWTD");
        wtdMap.put("CellularOne Retail TS", "RetailTSWTD");
        wtdMap.put("CellularOne Web Orders Email", "WebOrdersEmailWTD");

    }

    @Override
    protected XSSFWorkbook run(List<String> source) throws InvalidFormatException, IOException {
        setDate(source);

        List<String> lengthFilteredSource = this.filterByLength(source, 2);

        openWorkbook();

        Set<String> keySet = wtdMap.keySet();

        for (String item : keySet) {
            String summary = getMatchingLine(lengthFilteredSource, item);
            String cleanedSummary = cleanString(summary);
            composeExcelSheet(cleanedSummary, wtdMap.get(item));
        }

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
    public String getTableName(String key) {
        return wtdMap.get(key);
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