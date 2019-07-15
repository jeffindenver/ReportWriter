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

    final static Map<String, Report> reportTypes = initializeMap();

    private ReportConstants() {
    }

    private static Map<String, Report> initializeMap() {

        Map<String, Report> reportMap = new HashMap<>();

        reportMap.put("CellOne_Summary_WTD_QBD", new CellOne_Subtotal_WTD_QBD());
        reportMap.put("CellOne_Summary_MTD_QBD", new CellOne_Subtotal_MTD_QBD());
        reportMap.put("CellOneMonthlyQBD", new CellOneMonthlyQBD());
        reportMap.put("CellOneMonthlyBigThreeQBD", new CellOneMonthlyBigThreeQBD());
        reportMap.put("CellOne_MTD_QBD", new CellOne_MTD_QBD());
        reportMap.put("CellOne_WTD_QBD", new CellOne_WTD_QBD());

        reportMap.put("ChildrensVillageMonthlyQBD", new ChildrensVillageMonthlyQBD());
        reportMap.put("ChildrensVillageMonthlyShortAband", new ChildrensVillageMonthlyShortAband());

        reportMap.put("CPaTCallsQBD", new CPaTQBD());
        reportMap.put("CPaTShortAband", new CPaTShortAband());
        reportMap.put("CPaTMonthlyQBD", new CPaTMonthlyQBD());
        reportMap.put("CPaTMonthlyEmailQBD", new CPaTMonthlyEmailQBD());
        reportMap.put("CPaTMonthlyShortAband", new CPaTMonthlyShortAband());

        reportMap.put("EntrustCallsQBD", new EntrustQBD());
        reportMap.put("EntrustEmailQBD", new EmailEntrustQBD());
        reportMap.put("EntrustShortAband", new EntrustShortAband());
        reportMap.put("EntrustMonthlyCallsQS", new EntrustMonthlyCallsQS());
        reportMap.put("EntrustMonthlyEmailQS", new EntrustMonthlyEmailQS());


        reportMap.put("GPSTrackitCallsQBD", new GPSTrackitQBD());
        reportMap.put("GPSTrackitEmailQBD", new GPSTrackitEmailQBD());
        reportMap.put("GPSTrackitShortAband", new GPSTrackitShortAband());
        reportMap.put("GPSTrackitMonthlyQBD", new GPSTrackitMonthlyQBD());
        reportMap.put("GPSTrackitMonthlyShortAband", new GPSTrackitMonthlyShortAband());

        reportMap.put("MSRB_MonthlyCallsQBD", new MSRB_MonthlyCallsQBD());
        reportMap.put("MSRB_MonthlyEmailQBD", new MSRB_MonthlyEmailQBD());
        reportMap.put("MSRB_MonthlyShortAband", new MSRB_MonthlyShortAband());

        reportMap.put("NaturalWirelessCallsQBD", new NaturalWirelessQBD());
        reportMap.put("NaturalWirelessShortAband", new NaturalWirelessShortAband());
        reportMap.put("NaturalWirelessMonthlyCallsQS", new NaturalWirelessMonthlyCallsQS());

        reportMap.put("NelnetCallsQBD", new NelnetQBD());
        reportMap.put("NelnetShortAband", new NelnetShortAband());
        reportMap.put("NelnetMonthlyQBD", new NelnetMonthlyQBD());
        reportMap.put("NelnetMonthlyShortAband", new NelnetMonthlyShortAband());

        reportMap.put("OrbitPhoneMTD", new OrbitPhoneMTD());
        reportMap.put("OrbitChatMTD", new OrbitChatMTD());
        reportMap.put("OrbitEmailMTD", new OrbitEmailMTD());
        reportMap.put("BhyvePhoneMTD", new BhyvePhoneMTD());
        reportMap.put("BhyveChatMTD", new BhyveChatMTD());
        reportMap.put("BhyveEmailMTD", new BhyveEmailMTD());
        reportMap.put("HydroRainPhoneMTD", new HydroRainPhoneMTD());

        reportMap.put("OrbitCallsQBD", new OrbitCallsQBD());
        reportMap.put("OrbitShortAband", new OrbitShortAband());
        reportMap.put("OrbitChatQBD", new OrbitChatQBD());
        reportMap.put("OrbitChatShortAband", new OrbitChatShortAband());
        reportMap.put("OrbitEmailQBD", new OrbitEmailQBD());
        reportMap.put("OrbitCallbacksQBD", new OrbitCallbacksQBD());
        reportMap.put("OrbitHydroRainQBD", new OrbitHydroRainQBD());
        reportMap.put("OrbitHydroRainCallbackQBD", new OrbitHydroRainCallbackQBD());
        reportMap.put("OrbitHydroRainWeeklyQS", new OrbitHydroRainWeeklyQS());
        reportMap.put("OrbitHydroRainWeeklyCallbackQS", new OrbitHydroRainWeeklyCallbackQS());
        reportMap.put("OrbitBhyveMonthlyCallsQBD", new OrbitBhyveMonthlyCallsQBD());
        reportMap.put("OrbitBhyveMonthlyChatQBD", new OrbitBhyveMonthlyChatQBD());
        reportMap.put("OrbitBhyveMonthlyCallbacksQBD", new OrbitBhyveMonthlyCallbacksQBD());
        reportMap.put("OrbitBhyveMonthlyEmailQBD", new OrbitBhyveMonthlyEmailQBD());
        reportMap.put("OrbitBhyveWeeklyCallsQS", new OrbitBhyveWeeklyCallsQS());
        reportMap.put("OrbitBhyveWeeklyEmailQS", new OrbitBhyveWeeklyEmailQS());
        reportMap.put("OrbitBhyveWeeklyChatQS", new OrbitBhyveWeeklyChatQS());
        reportMap.put("OrbitBhyveWeeklyCallbacksQS", new OrbitBhyveWeeklyCallbacksQS());
        reportMap.put("OrbitIrrigationWeeklyCallsQS", new OrbitIrrigationWeeklyCallsQS());
        reportMap.put("OrbitIrrigationWeeklyEmailQS", new OrbitIrrigationWeeklyEmailQS());
        reportMap.put("OrbitIrrigationWeeklyChatQS", new OrbitIrrigationWeeklyChatQS());
        reportMap.put("OrbitIrrigationWeeklyCallbacksQS", new OrbitIrrigationWeeklyCallbacksQS());
        reportMap.put("OrbitHydroRainShortAband", new OrbitHydroRainShortAband());
        reportMap.put("OrbitBhyveMonthlyCallsShortAband", new OrbitBhyveMonthlyCallsShortAband());
        reportMap.put("OrbitBhyveMonthlyChatShortAband", new OrbitBhyveMonthlyChatShortAband());

        reportMap.put("PingIdentityCallsQBD", new PingIdentityQBD());
        reportMap.put("PingIdentityShortAband", new PingIdentityShortAband());

        reportMap.put("SergeantsMonthlyQS", new SergeantsMonthlyQS());

        reportMap.put("SwitchmateMonthlyQBD", new SwitchmateMonthlyQBD());
        reportMap.put("SwitchmateEmailMonthlyQBD", new SwitchmateEmailMonthlyQBD());
        reportMap.put("SwitchmateMonthlyShortAband", new SwitchmateMonthlyShortAband());

        reportMap.put("ServiceChannelQS", new ServiceChannelQS());

        reportMap.put("YKHC_MonthlyCallsQBD", new YKHC_MonthlyCallsQBD());
        reportMap.put("YKHC_MonthlyShortAband", new YKHC_MonthlyShortAband());

        return reportMap;
    }

}
