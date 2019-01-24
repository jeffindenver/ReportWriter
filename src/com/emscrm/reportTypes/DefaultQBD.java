package com.emscrm.reportTypes;

import com.emscrm.QueueByDateReport;

/**
 * @author JShepherd
 */
public class DefaultQBD extends QueueByDateReport {
    private static final String reportName = "DefaultQBD";

    public DefaultQBD() {

        super(new String[]{"none"},
                new String[]{"none"});
    }

    @Override
    public String toString() {
        return reportName;
    }
}
