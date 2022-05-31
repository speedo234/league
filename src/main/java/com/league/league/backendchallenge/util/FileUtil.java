package com.league.league.backendchallenge.util;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



public class FileUtil {



    public static List<CSVRecord> getCSVRecordsFromInputFile(MultipartFile file) throws IOException {
        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        return records.getRecords();
    }



    public static List<List<Integer>> getMatrixFromCSVRecords(List<CSVRecord> csvRecordList) throws IOException {
        List<List<Integer>> listArrayList = new ArrayList<List<Integer>>();
        List<Integer> integerList = null;
        for (CSVRecord record : csvRecordList) {
            integerList = new ArrayList<>();

            for(int i = 0; i < csvRecordList.size(); i++){
                integerList.add( Integer.parseInt(record.get(i)) );
            }
            listArrayList.add(integerList);
        }
        return listArrayList;
    }


    public static String doMatrixFormatString(List<List<Integer>> integerList1){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){
                stringBuilder.append(innerList.get(x));

                doLineProcessor(stringBuilder, x, innerList.size());

            }
        }
        stringBuilder.append("```");
        return stringBuilder.toString();
    }


    public static String doMatrixFormatStringInverted(List<List<Integer>> integerList1){
        StringBuilder stringBuilder = new StringBuilder();
        for(int x = 0; x < integerList1.size(); x++){
            for(int i = 0; i < integerList1.size(); i++){

                integerList1.get(i).get(x);
                stringBuilder.append( integerList1.get(i).get(x) );

                doLineProcessor(stringBuilder, i, integerList1.size());

            }
        }
        stringBuilder.append("```");
        return stringBuilder.toString();
    }

    public static String doMatrixFormatStringFlatten(List<List<Integer>> integerList1){
        int elementCount = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){
                stringBuilder.append(innerList.get(x));

                elementCount = elementCount+1;
                doSingleLineProcessor(stringBuilder, i, innerList.size(), elementCount);

            }
        }
        stringBuilder.append("\n");
        stringBuilder.append("```");
        return stringBuilder.toString();
    }


    public static int doMatrixSum(List<List<Integer>> integerList1){
        int matrixSummation = 0;

        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){

                matrixSummation = matrixSummation + innerList.get(x);

            }
        }
        return matrixSummation;
    }


    public static int doMatrixMultiply(List<List<Integer>> integerList1){
        int matrixMultiplication = 1;

        for(int i = 0; i < integerList1.size(); i++){
            List<Integer> innerList = integerList1.get(i);
            for(int x = 0; x < innerList.size(); x++){

                matrixMultiplication = matrixMultiplication * innerList.get(x);

            }
        }
        return matrixMultiplication;
    }



    public static void printMatrix(List<List<Integer>> integerList1){
        for(List<Integer> integerList :integerList1){
            System.out.println(integerList);
        }
    }


    private static void doLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize){
        if(indexControl+1 != listSize)
            stringBuilder.append(",");

        if((indexControl+1) % listSize == 0)
            stringBuilder.append("\n");
    }


    private static void doSingleLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize, int elementCount){
        if(elementCount < listSize*listSize )
            stringBuilder.append(",");
    }


    public static int getMatrixSize(List<CSVRecord> csvRecordList){
        return csvRecordList.size();
    }


}
