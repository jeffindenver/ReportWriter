package com.emscrm;

import com.emscrm.reportTypes.DefaultQBD;

/**
 * ReportWriter is version 2 of the FileProcessor application. The previous is
 * limited to processing data from tab delimited files. However, our CaaS
 * company will only export either pdf or xls files when dealing with scheduled
 * reports. Because we want to automate the creation of these reports, we must
 * add the ability to read and write Excel files.
 * <p>
 * Step 1 -- add Excel ops to the app. Step 2 -- read each file for each report
 * type and export all of them, one per line, to a single excel or csv file.
 * Step 3 -- Instead of exporting to a single file, read each source file and
 * write/modify existing reports.
 * <p>
 * Steps 1 and 2 are complete.
 *
 * @author JShepherd
 */
public class ReportWriter {

    public static void main(String[] args) {

        QueueByDateReport report = new DefaultQBD();

        Model model = new Model(new ReportComposer(report));

        ReportWriterGUI view = new ReportWriterGUI();

        Controller controller = new Controller(view, model);

        controller.start();
    }

}
