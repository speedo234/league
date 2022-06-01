package com.league.league.backendchallenge.service.impl;


import com.league.league.backendchallenge.service.ResponseService;
import com.league.league.backendchallenge.service.ValidationService;
import com.league.league.backendchallenge.util.MatrixUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResponseServiceImpl implements ResponseService {


    @Autowired
    ValidationService validationService;


//    public static List<CSVRecord> getCSVRecordsFromInputFile(MultipartFile file) throws IOException {
//        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
//        return records.getRecords();
//    }



//    public static List<List<Integer>> getMatrixFromCSVRecords(List<CSVRecord> csvRecordList) throws IOException {
//        List<List<Integer>> listArrayList = new ArrayList<List<Integer>>();
//        List<Integer> integerList = null;
//        CSVRecord tempArrayLine = null;
//        for (int x = 0; x < csvRecordList.size(); x++) {
//            integerList = new ArrayList<>();
//
//            tempArrayLine = csvRecordList.get(x);
//
//            for(int i = 0; i < tempArrayLine.size(); i++){
//
//                if(!ValidationService.isInputAnInteger( tempArrayLine.get(i) ))
//                    throw new InvalidInputException("value "+tempArrayLine.get(i)+" entered at index "+x+" "+i+" is an invalid integer...");
//
//                integerList.add( Integer.parseInt( tempArrayLine.get(i) ) );
//            }
//            listArrayList.add(integerList);
//        }
//        return listArrayList;
//    }


    public String doMatrixFormatString(List<List<Integer>> integerList1){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){
                stringBuilder.append(innerList.get(x));

                MatrixUtil.doMultiLineProcessor(stringBuilder, x, innerList.size());

            }
        }
        stringBuilder.append("```");
        return stringBuilder.toString();
    }


    public String doMatrixFormatStringInverted(List<List<Integer>> integerList1){
        StringBuilder stringBuilder = new StringBuilder();
        for(int x = 0; x < integerList1.size(); x++){
            for(int i = 0; i < integerList1.size(); i++){

                integerList1.get(i).get(x);
                stringBuilder.append( integerList1.get(i).get(x) );

                MatrixUtil.doMultiLineProcessor(stringBuilder, i, integerList1.size());

            }
        }
        stringBuilder.append("```");
        return stringBuilder.toString();
    }

    public String doMatrixFormatStringFlatten(List<List<Integer>> integerList1){
        int elementCount = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){
                stringBuilder.append(innerList.get(x));

                elementCount = elementCount+1;
                MatrixUtil.doSingleLineProcessor(stringBuilder, i, innerList.size(), elementCount);

            }
        }
        stringBuilder.append("\n");
        stringBuilder.append("```");
        return stringBuilder.toString();
    }


    public int doMatrixSum(List<List<Integer>> integerList1){
        int matrixSummation = 0;

        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){

                matrixSummation = matrixSummation + innerList.get(x);

            }
        }
        return matrixSummation;
    }


    public int doMatrixMultiply(List<List<Integer>> integerList1){
        int matrixMultiplication = 1;

        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){

                matrixMultiplication = matrixMultiplication * innerList.get(x);

            }
        }
        return matrixMultiplication;
    }



}
