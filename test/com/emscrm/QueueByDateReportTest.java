package com.emscrm;

import com.emscrm.reportTypes.DefaultQBD;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueueByDateReportTest {
    private Report report = new DefaultQBD();
    private List<String> testList;

    @BeforeEach
    @SuppressWarnings("unchecked")
    void setUp() {
        Model model = new Model(report);
        testList = Collections.EMPTY_LIST;
        try {
            String inputFilename = "testInputFile.xls";
            testList = model.readXlsFileToList(inputFilename);
        } catch(InvalidFormatException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void run() {
        XSSFWorkbook wb = null;
        try {
            wb = report.run(testList);
        } catch (InvalidFormatException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        assertNotNull(wb);
        System.out.println(wb.toString());

    }

}