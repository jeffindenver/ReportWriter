package com.emscrm;

import com.emscrm.reportTypes.CPaTQBD;
import com.emscrm.reportTypes.DefaultQBD;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private Model model;
    private List<String> source;
    private String inputFilename = "testInputFile.xls";
    private Report report = new DefaultQBD();

    @BeforeEach
    void setUp() {
        model = new Model(report);
        try {
            source = model.readXlsFileToList(inputFilename);
        } catch(InvalidFormatException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void runReport() {
        try {
            model.runReport(source);
        } catch(InvalidFormatException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void readXlsFileToList() {
        @SuppressWarnings("unchecked")
        List<String> testList = Collections.EMPTY_LIST;
        try {
            testList = model.readXlsFileToList(inputFilename);
        } catch(InvalidFormatException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("List size is " + testList.size());
        assertTrue(testList.size() > 0);
    }

    @Test
    void getReport() {
       Report testReport = model.getReport();
       assertNotNull(testReport);
       String expected = "DefaultQBD";
       String actual = testReport.toString();
       assertEquals(expected, actual);
    }

    @Test
    void setReport() {
        Report cpat = new CPaTQBD();
        model.setReport(cpat);
        String expected = "CPaT";
        String actual = cpat.toString();
        assertEquals(expected, actual);
    }

}