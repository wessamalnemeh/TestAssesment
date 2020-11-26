package com.assecor.assessment.test.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CSVService {

    private final String CSVFileName = "sample-input.csv";

    public CSVService(){ }

    public BufferedReader readData() {
        try {
            String line = "";
            String resourcePath = "classpath:" + this.getCSVFileName();
            File CSVFile = ResourceUtils.getFile(resourcePath);
            BufferedReader br = new BufferedReader(new FileReader(CSVFile));
            return br;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCSVFileName() {
        return CSVFileName;
    }



}
