package com.automationteststore.base;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CSVDataProvider {

    @DataProvider(name = "csvReader")
    public Iterator<Object[]> provider() {
        List<Object[]> testCases = new ArrayList<>();

        try {
            CSVReader reader = new CSVReader(new FileReader("src/test/resources/DataProviders/invalid_credentials.csv"));
            String[] columnNames = reader.readNext();
            if (columnNames != null) {
                String[] testValues;
                while ((testValues = reader.readNext()) != null) {
                    HashMap<String, String> testCase = new HashMap<>();
                    for (int i = 0; i < columnNames.length; i++) {
                        testCase.put(columnNames[i], testValues[i]);
                    }
                    testCases.add(new Object[]{testCase});
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }


        return testCases.iterator();


    }
}

