package com.emscrm;

import com.emscrm.reportTypes.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The QBD reports contain summaries by workgroup and by grand total. The
 * constants below correspond to the order of elements of those lines of the
 * exported report, shifted one to the right because account name is inserted
 * at the beginning.
 * <p>
 * The lines look like the following
 * Grand Total: 175 :07:09 20:51:15 :00:24 01:09:41 44 :02:52 20.09% :29:11
 * :01:04 74.86% 97.27%
 *
 * @author JShepherd
 */
final class ReportConstants {

    final static int ACCOUNT_NAME = 0;
    final static int GROUP_NAME = 1;
    final static int INTERACTIONS_ANSWERED = 2;
    final static int AVG_TALK_TIME = 3;
    final static int TOTAL_TALK_TIME = 4;
    final static int AVG_ACW = 5;
    final static int TOTAL_ACW = 6;
    final static int INTERACTIONS_ABANDONED = 7;
    final static int AVG_ABAND_DELAY = 8;
    final static int PERCENT_ABAN = 9;
    final static int MAX_WAIT = 10;
    final static int ASA = 11;
    final static int SVC_LVL = 12;

    final static int QBD_REPORT_LENGTH = 15;

    final static Map<String, Report> REPORT_TYPES = initializeMap();

    private ReportConstants() {
    }

    private static Map<String, Report> initializeMap() {
        Map<String, Report> map = new HashMap<>();
        map.put("CellOneCallsQBD", new CellOneQBD());
        map.put("CellOneDailyQBD", new CellOneQBD());
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
        map.put("NelnetShortAband", new NaturalWirelessShortAband());
        map.put("NetworkForGoodShortAband", new NetworkForGoodShortAband());
        map.put("PingIdentityShortAband", new PingIdentityShortAband());
        map.put("CustomerCareMTD", new CustomerCareMTD());
        map.put("CustomerCareWTD", new CustomerCareWTD());
        map.put("HotlineMTD", new HotlineMTD());
        map.put("HotlineWTD", new HotlineWTD());
        map.put("InfoEmailMTD", new InfoEmailMTD());
        map.put("InfoEmailWTD", new InfoEmailWTD());
        map.put("NMActivateMTD", new NMActivateMTD());
        map.put("NMActivateWTD", new NMActivateWTD());
        map.put("NMInfoEmailMTD", new NMInfoEmailMTD());
        map.put("NMInfoEmailWTD", new NMInfoEmailWTD());
        map.put("NMRenewMTD", new NMRenewMTD());
        map.put("NMRenewWTD", new NMRenewWTD());
        map.put("NMWebSalesEmailMTD", new NMWebSalesEmailMTD());
        map.put("NMWebsSalesEmailWTD", new NMWebSalesEmailWTD());
        map.put("PrepaidCSMTD", new PrepaidCSMTD());
        map.put("PrepaidCSWTD", new PrepaidCSWTD());
        map.put("PrepaidTSMTD", new PrepaidTSMTD());
        map.put("PrepaidTSWTD", new PrepaidTSWTD());
        map.put("RecertificationMTD", new RecertificationMTD());
        map.put("RecertificationWTD", new RecertificationWTD());
        map.put("RetailCSMTD", new RetailCSMTD());
        map.put("RetailCSWTD", new RetailCSWTD());
        map.put("RetailPaymentMTD", new RetailPaymentMTD());
        map.put("RetailPaymentWTD", new RetailPaymentWTD());
        map.put("RetailTSMTD", new RetailTSMTD());
        map.put("RetailTSWTD", new RetailTSWTD());
        map.put("WebOrdersEmailMTD", new WebOrdersEmailMTD());
        map.put("WebOrdersEmailWTD", new WebOrdersEmailWTD());

        return map;
    }

}
