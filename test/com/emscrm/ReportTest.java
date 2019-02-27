package com.emscrm;

import com.emscrm.reportTypes.DefaultQBD;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {
    private List<String> testList;
    private final Report report = new DefaultQBD();

    @SuppressWarnings("unchecked")
    @BeforeEach
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
    void getMatchingLine() {
        String matcher = "CPaT Chat";
        ListFilter listFilter = new ListFilter();
        List<String> filteredList = listFilter.filterByLength(3, testList, "\t");
        String result = report.getMatchingLine(filteredList, matcher);

        filteredList.forEach(System.out::println);

        System.out.println(result);
        assertTrue(result.contains(matcher));
        String[] results = result.split("\t");
        assertTrue(results.length > 2);
    }

    @Test
    void openWorkbook() {
        try{
            report.openWorkbook();
        } catch (InvalidFormatException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}