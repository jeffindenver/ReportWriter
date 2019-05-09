package com.emscrm;

import com.emscrm.reportTypes.*;
import com.emscrm.reportTypes.shortAbandons.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The QBD reports contain summaries by workgroup subtotal and by grand total.
 *
 * @author JShepherd
 */
final class ReportConstants {

    final static Map<String, Report> REPORT_TYPES = initializeMap();

    private ReportConstants() {
    }

    private static Map<String, Report> initializeMap() {

        Map<String, Report> stringReportMap = new HashMap<>();

        stringReportMap.put("CellOne_Summary_WTD_QBD", new CellOne_Subtotal_WTD_QBD());
        stringReportMap.put("CellOne_Summary_MTD_QBD", new CellOne_Subtotal_MTD_QBD());
        stringReportMap.put("CellOneMonthlyQBD", new CellOneMonthlyQBD());
        stringReportMap.put("CellOneMonthlyBigThreeQBD", new CellOneMonthlyBigThreeQBD());
        stringReportMap.put("CellOne_MTD_QBD", new CellOne_MTD_QBD());
        stringReportMap.put("CellOne_WTD_QBD", new CellOne_WTD_QBD());

        stringReportMap.put("CPaTCallsQBD", new CPaTQBD());
        stringReportMap.put("CPaTShortAband", new CPaTShortAband());

        stringReportMap.put("EntrustCallsQBD", new EntrustQBD());
        stringReportMap.put("EntrustEmailQBD", new EmailEntrustQBD());
        stringReportMap.put("EntrustShortAband", new EntrustShortAband());

        stringReportMap.put("Three_DX_Email_QS", new Three_DX_Email_QS());
        stringReportMap.put("Three_DX_Calls_QS", new Three_DX_Calls_QS());

        stringReportMap.put("GPSTrackitCallsQBD", new GPSTrackitQBD());
        stringReportMap.put("GPSTrackitEmailQBD", new EmailGPSTrackitQBD());
        stringReportMap.put("GPSTrackitShortAband", new GPSTrackitShortAband());

        stringReportMap.put("NaturalWirelessCallsQBD", new NaturalWirelessQBD());
        stringReportMap.put("NaturalWirelessShortAband", new NaturalWirelessShortAband());

        stringReportMap.put("NelnetCallsQBD", new NelnetQBD());
        stringReportMap.put("NelnetShortAband", new NelnetShortAband());

        stringReportMap.put("OrbitPhoneMTD", new OrbitPhoneMTD());
        stringReportMap.put("OrbitChatMTD", new OrbitChatMTD());
        stringReportMap.put("OrbitEmailMTD", new OrbitEmailMTD());
        stringReportMap.put("BhyvePhoneMTD", new BhyvePhoneMTD());
        stringReportMap.put("BhyveChatMTD", new BhyveChatMTD());
        stringReportMap.put("BhyveEmailMTD", new BhyveEmailMTD());
        stringReportMap.put("HydroRainPhoneMTD", new HydroRainPhoneMTD());

        stringReportMap.put("OrbitCallsQBD", new OrbitCallsQBD());
        stringReportMap.put("OrbitShortAband", new OrbitShortAband());
        stringReportMap.put("OrbitChatQBD", new OrbitChatQBD());
        stringReportMap.put("OrbitChatShortAband", new OrbitChatShortAband());
        stringReportMap.put("OrbitEmailQBD", new OrbitEmailQBD());
        stringReportMap.put("OrbitHydroRainQBD", new OrbitHydroRainQBD());
        stringReportMap.put("OrbitHydroRainWeeklyQS", new OrbitHydroRainWeeklyQS());
        stringReportMap.put("OrbitHydroRainWeeklyCallbackQS", new OrbitHydroRainWeeklyCallbackQS());
        stringReportMap.put("OrbitBhyveMonthlyCallsQBD", new OrbitBhyveMonthlyCallsQBD());
        stringReportMap.put("OrbitBhyveMonthlyChatQBD", new OrbitBhyveMonthlyChatQBD());
        stringReportMap.put("OrbitBhyveMonthlyEmailQBD", new OrbitBhyveMonthlyEmailQBD());
        stringReportMap.put("OrbitBhyveWeeklyCallsQS", new OrbitBhyveWeeklyCallsQS());
        stringReportMap.put("OrbitBhyveWeeklyEmailQS", new OrbitBhyveWeeklyEmailQS());
        stringReportMap.put("OrbitBhyveWeeklyChatQS", new OrbitBhyveWeeklyChatQS());
        stringReportMap.put("OrbitHydroRainCallbackQBD", new OrbitHydroRainCallbackQBD());
        stringReportMap.put("OrbitIrrigationWeeklyCallsQS", new OrbitIrrigationWeeklyCallsQS());
        stringReportMap.put("OrbitIrrigationWeeklyEmailQS", new OrbitIrrigationWeeklyEmailQS());
        stringReportMap.put("OrbitIrrigationWeeklyChatQS", new OrbitIrrigationWeeklyChatQS());
        stringReportMap.put("OrbitHydroRainShortAband", new OrbitHydroRainShortAband());
        stringReportMap.put("OrbitBhyveMonthlyCallsShortAband", new OrbitBhyveMonthlyCallsShortAband());
        stringReportMap.put("OrbitBhyveMonthlyChatShortAband", new OrbitBhyveMonthlyChatShortAband());      

        stringReportMap.put("PingIdentityCallsQBD", new PingIdentityQBD());
        stringReportMap.put("PingIdentityShortAband", new PingIdentityShortAband());

        stringReportMap.put("SergeantsMonthlyQS", new SergeantsMonthlyQS());

        stringReportMap.put("ServiceChannelQS", new ServiceChannelQS());

        return stringReportMap;
    }

}
