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
import java.time.LocalDate;
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
                    droppedFiles
                            = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
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
            writeSummaryToExcelFile(line);

            String reportName = model.getReportName();
            line = reportName + "\t" + line;
            output.add(line);
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

        model.setFilter(new ReportComposer(selectReport(pathname)));

        List<String> source = readReport(pathname);

        LocalDate date = getReportDate(source);
        model.getFilter().getReport().setDate(date);

        String summary = getSummaryLine(source);

        return model.cleanString(summary);
    }

    private LocalDate getReportDate(List<String> source) {

        if (isEmptyList(source)) {
            return LocalDate.MIN;
        }
        return model.getDateFromList(source);
    }

    private String getSummaryLine(List<String> source) {

        if (isEmptyList(source)) {
            return "";
        }
        return model.getSummary(source);
    }

    private void writeSummaryToExcelFile(String summary) {
        try {
            model.writeSummaryToExcelFile(summary);
        } catch (InvalidFormatException | IOException e) {
            view.printError(e.getMessage());
        }
    }

    private List<String> readReport(String filename) {
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

    private QueueByDateReport selectReport(String filepath) {

        QueueByDateReport report = new DefaultQBD();
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
