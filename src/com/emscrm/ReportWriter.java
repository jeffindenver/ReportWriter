package com.emscrm;

import com.emscrm.reportTypes.DefaultQBD;

/**
 * ReportWriter reads excel reports generated by a vendor, transforms the data, and then writes it
 * to existing Excel files.
 *
 * @author JShepherd
 */
class ReportWriter {

    private ReportWriter(){}

    public static void main(String[] args) {

        QueueByDateReport report = new DefaultQBD();

        Model model = new Model(report);

        ReportWriterGUI view = new ReportWriterGUI();

        Controller controller = new Controller(view, model);

        controller.start();
    }

}
