package com.emscrm;

import javax.swing.*;
import java.awt.*;

/**
 * @author JShepherd
 */
class ReportWriterGUI {

    private final JFrame frame;
    private final JTextArea textArea;
    private final JLabel status;

    ReportWriterGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setBounds(40, 40, 600, 400);

        textArea = new JTextArea("Drop XLS or XLSX files below for processing.\n");
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setOpaque(false);
        Insets inset = new Insets(20, 20, 20, 20);
        textArea.setMargin(inset);
        textArea.setEditable(false);
        textArea.setBackground(Color.darkGray);
        textArea.setForeground(Color.white);

        status = new JLabel("status");

        frame.add(status, BorderLayout.PAGE_END);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    void setStatus(String msg) {
        this.status.setText(msg);
    }

    JTextArea getTextArea() {
        return textArea;
    }

    void printError(String msg) {
        JOptionPane.showMessageDialog(frame, msg);
    }

    @SuppressWarnings("SameParameterValue")
    void printMessage(String msg) {
        textArea.append(System.getProperty("line.separator"));
        textArea.append(msg);
    }
}
