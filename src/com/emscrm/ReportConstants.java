package com.emscrm;

import com.emscrm.reportTypes.*;
import com.emscrm.reportTypes.ShortAbandons.*;

import java.util.Map;

import static java.util.Map.entry;

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

        return Map.ofEntries(
                entry("Three_DX_Email_QS", new Three_DX_Email_QS()),
                entry("Three_DX_Calls_QS", new Three_DX_Calls_QS()),
                entry("CellOne_Summary_WTD_QBD", new CellOne_Subtotal_WTD_QBD()),
                entry("CellOne_Summary_MTD_QBD", new CellOne_Subtotal_MTD_QBD()),
                entry("CellOne_MTD_QBD", new CellOne_MTD_QBD()),
                entry("CellOne_WTD_QBD", new CellOne_WTD_QBD()),
                entry("CPaTCallsQBD", new CPaTQBD()),
                entry("EntrustCallsQBD", new EntrustQBD()),
                entry("GPSTrackitCallsQBD", new GPSTrackitQBD()),
                entry("GPSTrackitEmailQBD", new EmailGPSTrackitQBD()),
                entry("NaturalWirelessCallsQBD", new NaturalWirelessQBD()),
                entry("NelnetCallsQBD", new NelnetQBD()),
                entry("NetworkForGoodCallsQBD", new NetworkForGoodQBD()),
                entry("OrbitCallsQBD", new OrbitQBD()),
                entry("PingIdentityCallsQBD", new PingIdentityQBD()),
                entry("EntrustEmailQBD", new EmailEntrustQBD()),
                entry("NetworkForGoodEmailQBD", new EmailNetworkForGoodQBD()),
                entry("NetworkForGoodVMQBD", new VMNetworkForGoodQBD()),
                entry("CPaTShortAband", new CPaTShortAband()),
                entry("EntrustShortAband", new EntrustShortAband()),
                entry("GPSTrackitShortAband", new GPSTrackitShortAband()),
                entry("NaturalWirelessShortAband", new NaturalWirelessShortAband()),
                entry("NelnetShortAband", new NelnetShortAband()),
                entry("NetworkForGoodShortAband", new NetworkForGoodShortAband()),
                entry("PingIdentityShortAband", new PingIdentityShortAband())
        );
    }

}
