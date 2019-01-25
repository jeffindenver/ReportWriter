package com.emscrm;

import com.emscrm.reportTypes.DefaultQBD;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author JShepherd
 */
public class Controller {

    private final Model model;
    private final ReportWriterGUI view;

    Controller(ReportWriterGUI aView, Model aModel) {
        this.view = aView;
        this.model = aModel;
    }

    void start() {
        startListeners();
    }

    private void startListeners() {

        view.getTextArea().setDropTarget(new DropTarget() {
            private static final long serialVersionUID = 1L;

            @Override
            @SuppressWarnings("unchecked")
            public synchronized void drop(DropTargetDropEvent evt) {
                List<File> droppedFiles = Collections.EMPTY_LIST;
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    droppedFiles = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                } catch (UnsupportedFlavorException | IOException ex) {
                    view.printError(ex.getMessage());
                }
                processDroppedFiles(droppedFiles);
            }
        });
    }

    private void processDroppedFiles(List<File> droppedFiles) {
        List<String> output = new ArrayList<>();

        for (File file : droppedFiles) {
            String line = processFile(file);
//            writeSummaryToExcelFile(line);

            String namePlusLine = model.getReportName() + "\t" + line;
            output.add(namePlusLine);
        }

        List<String> formattedOutput = output.stream()
                .map(model::formatRow)
                .collect(Collectors.toList());

        model.writeListToFile(formattedOutput);

        view.setStatus(formattedOutput.size() + " files processed.");
    }

    private String processFile(File file) {
        String pathname = file.toString();

        view.printMessage(pathname);

        model.setComposer(new ReportComposer(selectReport(pathname)));

        List<String> source = readSourceFile(pathname);

        String summary = "";
        try {
           summary = model.runReport(source);
           System.out.println("In controller::processFile method. Summary equals " + summary);
        } catch(InvalidFormatException | IOException e) {
            view.printError(e.getMessage());
        }

        return summary;
    }

    private void writeSummaryToExcelFile(String summary) {
        try {
            model.writeSummaryToExcelFile(summary);
        } catch (InvalidFormatException | IOException e) {
            view.printError(e.getMessage());
        }
    }

    private List<String> readSourceFile(String filename) {
        @SuppressWarnings("unchecked")
        List<String> list = Collections.EMPTY_LIST;
        try {
            list = model.readXlsFileToList(filename);

        } catch (IOException | InvalidFormatException e) {
            view.printError(e.getMessage());
        }
        return list;
    }

    private boolean isEmptyList(List<String> list) {
        if (list.isEmpty()) {
            view.printError("The filename was not valid.");
        }
        return list.isEmpty();
    }

    private Report selectReport(String filepath) {

        Report report = new DefaultQBD();
        Set<String> keys = QbdConstants.REPORT_TYPES.keySet();

        for (String s : keys) {
            if (filepath.contains(s)) {
                report = QbdConstants.REPORT_TYPES.get(s);
                break;
            }
        }
        return report;
    }

    @Override
    public String toString() {
        return ("Model - " + model.toString() + "\n" + "View - " + view.toString());
    }

}
