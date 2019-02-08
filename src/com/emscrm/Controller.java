package com.emscrm;

import com.emscrm.reportTypes.DefaultQBD;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jetbrains.annotations.NotNull;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author JShepherd
 */
class Controller {

    private final Model model;
    private final ReportWriterGUI view;
    private int countOfFilesProcessed;

    Controller(ReportWriterGUI aView, Model aModel) {
        this.view = aView;
        this.model = aModel;
        countOfFilesProcessed = 0;
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
                view.setStatus(countOfFilesProcessed + " files processed.");
            }
        });
    }

    private void processDroppedFiles(List<File> droppedFiles) {
        for (File file : droppedFiles) {

            processFile(file);

            countOfFilesProcessed++;
        }
    }

    private void processFile(File file) {
        String pathname = file.toString();

        model.setComposer(new ReportComposer(selectReport(pathname)));

        List<String> source = readSourceFile(pathname);

        try {
            model.runReport(source);
        } catch (InvalidFormatException | IOException e) {
            view.printError(e.getMessage());
        }

        view.printMessage(pathname);
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

    @NotNull
    private Report selectReport(String filepath) {
        //change this to use Optional<T>
        Report report = new DefaultQBD();
        Set<String> keys = ReportConstants.REPORT_TYPES.keySet();

        for (String key : keys) {
            if (filepath.contains(key)) {
                report = ReportConstants.REPORT_TYPES.get(key);
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
