package com.emscrm;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * The Controller class holds a reference to the view and the model and handles the one and only event, which
 * is a drag and drop to the GUI.
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
                new ProcessFileTask(droppedFiles).execute();
            }
        });
    }

    @NotNull
    private Report selectReport(String filepath) {
        Report report = model.getReport();

        Set<String> keys = ReportConstants.reportTypes.keySet();

        for (String key : keys) {
            if (filepath.contains(key)) {
                report = ReportConstants.reportTypes.get(key);
                break;
            }
        }
        return report;
    }

    private List<String> readSourceFile(String filename) {
        @SuppressWarnings("unchecked")
        List<String> list = Collections.EMPTY_LIST;
        try {
            list = model.readXlsSheetToList(filename);

        } catch (IOException | InvalidFormatException e) {
            view.printError(e.getMessage());
        }
        return list;
    }

    private void updateView() {
        view.setStatus(countOfFilesProcessed + " files processed.");
    }

    @Override
    public String toString() {
        return ("Model - " + model.toString() + "\n" + "View - " + view.toString());
    }

    private class ProcessFileTask extends SwingWorker<Integer, String> {
        //SwingWorker<T, V>
        // T is return type of doInBackground and get methods
        // V is the type used to carry out intermediate results by publish and process methods
        final List<File> fileList;

        ProcessFileTask(List<File> list) {
            fileList = list;
        }

        @Override
        protected Integer doInBackground() {

            int count = 0;

            for (File file : fileList) {
                String filepath = file.toString();

                model.setReport(selectReport(filepath));

                List<String> source = readSourceFile(filepath);

                try {
                    model.runAndWriteReport(source);
                } catch (InvalidFormatException | IOException e) {
                    view.printError(e.getMessage());
                    System.out.println(Arrays.toString(e.getStackTrace()));
                }
                count++;
                publish(filepath);
            }

            return count;
        }

        @Override
        protected void process(List<String> chunks) {
            chunks.forEach(view::printMessage);
        }

        @Override
        protected void done() {
            try {
                countOfFilesProcessed = this.get();
                view.printMessage("Finished.");
                updateView();
            } catch (InterruptedException | ExecutionException ex) {
                view.printError(ex.getMessage());
            }
        }
    }
}
