package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

import java.util.Map;

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
            entry("CellularOne NakedMobile", "NakedMobileMTD"),
            entry("CellularOne NM Info Email", "NMInfoEmailMTD"),
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
        this.weeklyReportFilename = "s:\\reports\\call centers\\Cellular One of NE Arizona\\CellOne Daily.xlsx";
    }

    @Override
    public boolean isSingleLineTable() {
        return true;
    }

    @Override
    public Map<String, String> getTargetTableNames() {
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

