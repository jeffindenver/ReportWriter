package com.emscrm;

import com.emscrm.reportTypes.*;
import com.emscrm.reportTypes.ShortAbandons.*;
import com.emscrm.reportTypes.CellOne.*;


import java.util.HashMap;
import java.util.Map;

/**
 * The QBD reports contain summaries by workgroup and by grand total.
 *
 * @author JShepherd
 */
final class ReportConstants {

    final static int QBD_REPORT_LENGTH = 15;

    final static Map<String, Report> REPORT_TYPES = initializeMap();

    private ReportConstants() {
    }

    private static Map<String, Report> initializeMap() {
        Map<String, Report> map = new HashMap<>();
        map.put("CellOne_MTD_QBD", new CellOne_MTD_QBD());
        map.put("CellOne_WTD_QBD", new CellOne_WTD_QBD());
        map.put("CPaTCallsQBD", new CPaTQBD());
        map.put("EntrustCallsQBD", new EntrustQBD());
        map.put("GPSTrackitCallsQBD", new GPSTrackitQBD());
        map.put("GPSTrackitEmailQBD", new EmailGPSTrackitQBD());
        map.put("HabitatReStoreCallsQBD", new HabitatReStoreQBD());
        map.put("NaturalWirelessCallsQBD", new NaturalWirelessQBD());
        map.put("NelnetCallsQBD", new NelnetQBD());
        map.put("NetworkForGoodCallsQBD", new NetworkForGoodQBD());
        map.put("NewmarkCallsQBD", new NewmarkQBD());
        map.put("OrbitCallsQBD", new OrbitQBD());
        map.put("PingIdentityCallsQBD", new PingIdentityQBD());
        map.put("EntrustEmailQBD", new EmailEntrustQBD());
        map.put("NetworkForGoodEmailQBD", new EmailNetworkForGoodQBD());
        map.put("NetworkForGoodVMQBD", new VMNetworkForGoodQBD());
        map.put("CPaTShortAband", new CPaTShortAband());
        map.put("EntrustShortAband", new EntrustShortAband());
        map.put("GPSTrackitShortAband", new GPSTrackitShortAband());
        map.put("HabitatReStoreShortAband", new HabitatReStoreShortAband());
        map.put("NaturalWirelessShortAband", new NaturalWirelessShortAband());
        map.put("NelnetShortAband", new NelnetShortAband());
        map.put("NetworkForGoodShortAband", new NetworkForGoodShortAband());
        map.put("PingIdentityShortAband", new PingIdentityShortAband());

        return map;
    }

}
