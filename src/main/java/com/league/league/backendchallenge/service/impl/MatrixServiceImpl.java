package com.league.league.backendchallenge.service.impl;


import com.league.league.backendchallenge.service.MatrixService;
import com.league.league.backendchallenge.util.FileUtil;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class MatrixServiceImpl implements MatrixService {


    @Override
    public String doMatrixGiven(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = FileUtil.getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = FileUtil.getMatrixFromCSVRecords(csvRecordList);
        return FileUtil.doMatrixFormatString(integerList1);
    }

    @Override
    public String doMatrixInverted(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = FileUtil.getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = FileUtil.getMatrixFromCSVRecords(csvRecordList);
        return FileUtil.doMatrixFormatStringInverted(integerList1);
    }

    @Override
    public String doMatrixFlatten(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = FileUtil.getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = FileUtil.getMatrixFromCSVRecords(csvRecordList);
        return FileUtil.doMatrixFormatStringFlatten(integerList1);
    }


    @Override
    public int doMatrixSum(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = FileUtil.getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = FileUtil.getMatrixFromCSVRecords(csvRecordList);
        return FileUtil.doMatrixSum(integerList1);
    }

    @Override
    public int doMatrixMultiply(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = FileUtil.getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = FileUtil.getMatrixFromCSVRecords(csvRecordList);
        return FileUtil.doMatrixMultiply(integerList1);
    }


}
