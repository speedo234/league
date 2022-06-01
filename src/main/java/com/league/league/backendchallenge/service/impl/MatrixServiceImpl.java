package com.league.league.backendchallenge.service.impl;


import com.league.league.backendchallenge.exception.InvalidInputException;
import com.league.league.backendchallenge.service.MatrixService;
import com.league.league.backendchallenge.service.ValidationService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class MatrixServiceImpl implements MatrixService {


    @Autowired
    ValidationService validationService;

    @Autowired
    ResponseServiceImpl responseService;


    @Override
    public String doMatrixGiven(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = getMatrixFromCSVRecords(csvRecordList);
        return responseService.doMatrixFormatString(integerList1);
    }

    @Override
    public String doMatrixInverted(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = getMatrixFromCSVRecords(csvRecordList);
        return responseService.doMatrixFormatStringInverted(integerList1);
    }

    @Override
    public String doMatrixFlatten(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = getMatrixFromCSVRecords(csvRecordList);
        return responseService.doMatrixFormatStringFlatten(integerList1);
    }


    @Override
    public int doMatrixSum(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = getMatrixFromCSVRecords(csvRecordList);
        return responseService.doMatrixSum(integerList1);
    }

    @Override
    public int doMatrixMultiply(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = getMatrixFromCSVRecords(csvRecordList);
        return responseService.doMatrixMultiply(integerList1);
    }


    private List<List<Integer>> getMatrixFromCSVRecords(List<CSVRecord> csvRecordList) throws IOException {
        List<List<Integer>> listArrayList = new ArrayList<List<Integer>>();
        List<Integer> integerList = null;
        CSVRecord tempArrayLine = null;
        for (int x = 0; x < csvRecordList.size(); x++) {
            integerList = new ArrayList<>();

            tempArrayLine = csvRecordList.get(x);

            for(int i = 0; i < tempArrayLine.size(); i++){

                if(!validationService.isInputAnInteger( tempArrayLine.get(i) ))
                    throw new InvalidInputException("value "+tempArrayLine.get(i)+" entered at index "+x+" "+i+" is an invalid integer...");

                integerList.add( Integer.parseInt( tempArrayLine.get(i) ) );
            }
            listArrayList.add(integerList);
        }
        return listArrayList;
    }


    private List<CSVRecord> getCSVRecordsFromInputFile(MultipartFile file) throws IOException {
        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        return records.getRecords();
    }

}
