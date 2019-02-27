package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Map;

import static java.util.Map.entry;


/**
 * @author JShepherd
 */
public final class CellOne_WTD_QBD extends QueueByDateReport {

    private static final String reportName = "Cellular One WTD";
    private final Map<String, String> weekToDateTableNames = Map.ofEntries(
            entry("CellularOne Customer Care", "CustomerCareWTD"),
            entry("CellularOne Hotline", "HotlineWTD"),
            entry("CellularOne Info Email", "InfoEmailWTD"),
            entry("CellularOne NM Activate", "NMActivateWTD"),
            entry("CellularOne NM Info Email", "NMInfoEmailWTD"),
            entry("CellularOne NM Renew", "NMRenewWTD"),
            entry("CellularOne NM Web Sales Email", "NMWebSalesEmailWTD"),
            entry("CellularOne Prepaid CS", "PrepaidCSWTD"),
            entry("CellularOne Prepaid TS", "PrepaidTSWTD"),
            entry("CellularOne Recertification", "RecertificationWTD"),
            entry("CellularOne Retail CS", "RetailCSWTD"),
            entry("CellularOne Retail Payment", "RetailPaymentWTD"),
            entry("CellularOne Retail TS", "RetailTSWTD"),
            entry("CellularOne Web Orders Email", "WebOrdersEmailWTD")
    );

    public CellOne_WTD_QBD() {
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne WTD MTD backup.xlsx";
    }

    @Override
    protected void composeExcelSheet(String summary, String tableName) {

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

    @Override
    public boolean overwrite() {
        return true;
    }

    @Override
    public Map<String, String> getTableNames() {
        return weekToDateTableNames;
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
