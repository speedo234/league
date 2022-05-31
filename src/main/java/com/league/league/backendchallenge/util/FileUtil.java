package com.league.league.backendchallenge.util;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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
            integerList.add( Integer.parseInt(record.get(0)) );
            integerList.add( Integer.parseInt(record.get(1)) );
            integerList.add( Integer.parseInt(record.get(2)) );
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

                if(x+1 != innerList.size())
                    stringBuilder.append(",");

                if((x+1) % innerList.size() == 0)
                    stringBuilder.append("\n");
            }
//            stringBuilder.append("\n");
        }
        stringBuilder.append("```");
        return stringBuilder.toString();
    }


    public static String doMatrixFormatStringInverted(List<List<Integer>> integerList1){
        StringBuilder stringBuilder = new StringBuilder();

        List<Integer> innerList = integerList1.get(0);

        for(int x = 0; x < integerList1.size(); x++){
            for(int i = 0; i < integerList1.size(); i++){

                integerList1.get(i).get(x);
                stringBuilder.append( integerList1.get(i).get(x) );

                if(i+1 != integerList1.size())
                    stringBuilder.append(",");

                if((i+1) % 3 == 0)
                    stringBuilder.append("\n");

            }
        }
        stringBuilder.append("```");
        return stringBuilder.toString();
    }


    public static void printMatrix(List<List<Integer>> integerList1){
        for(List<Integer> integerList :integerList1){
            System.out.println(integerList);
        }
    }



}
