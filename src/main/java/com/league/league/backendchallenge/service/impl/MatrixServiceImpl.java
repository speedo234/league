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
        String string = FileUtil.doMatrixFormatString(integerList1);
        return string;
    }

    @Override
    public String doMatrixInverted(MultipartFile file) throws IOException {
        List<CSVRecord> csvRecordList = FileUtil.getCSVRecordsFromInputFile(file);
        List<List<Integer>> integerList1 = FileUtil.getMatrixFromCSVRecords(csvRecordList);
        String string = FileUtil.doMatrixFormatStringInverted(integerList1);
        return string;
    }


}
