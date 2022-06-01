package com.league.league.backendchallenge.util;


import com.league.league.backendchallenge.service.ValidationService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class MatrixUtil {


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


//    public static String doMatrixFormatString(List<List<Integer>> integerList1){
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i < integerList1.size(); i++){
//            List<Integer> innerList = integerList1.get(i);
//            for(int x = 0; x < innerList.size(); x++){
//                stringBuilder.append(innerList.get(x));
//
//                doLineProcessor(stringBuilder, x, innerList.size());
//
//            }
//        }
//        stringBuilder.append("```");
//        return stringBuilder.toString();
//    }


//    public static String doMatrixFormatStringInverted(List<List<Integer>> integerList1){
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int x = 0; x < integerList1.size(); x++){
//            for(int i = 0; i < integerList1.size(); i++){
//
//                integerList1.get(i).get(x);
//                stringBuilder.append( integerList1.get(i).get(x) );
//
//                doLineProcessor(stringBuilder, i, integerList1.size());
//
//            }
//        }
//        stringBuilder.append("```");
//        return stringBuilder.toString();
//    }

//    public static String doMatrixFormatStringFlatten(List<List<Integer>> integerList1){
//        int elementCount = 0;
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i < integerList1.size(); i++){
//            List<Integer> innerList = integerList1.get(i);
//            for(int x = 0; x < innerList.size(); x++){
//                stringBuilder.append(innerList.get(x));
//
//                elementCount = elementCount+1;
//                doSingleLineProcessor(stringBuilder, i, innerList.size(), elementCount);
//
//            }
//        }
//        stringBuilder.append("\n");
//        stringBuilder.append("```");
//        return stringBuilder.toString();
//    }


//    public static int doMatrixSum(List<List<Integer>> integerList1){
//        int matrixSummation = 0;
//
//        for(int i = 0; i < integerList1.size(); i++){
//            List<Integer> innerList = integerList1.get(i);
//            for(int x = 0; x < innerList.size(); x++){
//
//                matrixSummation = matrixSummation + innerList.get(x);
//
//            }
//        }
//        return matrixSummation;
//    }


//    public static int doMatrixMultiply(List<List<Integer>> integerList1){
//        int matrixMultiplication = 1;
//
//        for(int i = 0; i < integerList1.size(); i++){
//            List<Integer> innerList = integerList1.get(i);
//            for(int x = 0; x < innerList.size(); x++){
//
//                matrixMultiplication = matrixMultiplication * innerList.get(x);
//
//            }
//        }
//        return matrixMultiplication;
//    }



    public static void printMatrix(List<List<Integer>> integerList1){
        for(List<Integer> integerList :integerList1){
            System.out.println(integerList);
        }
    }


    public static void doMultiLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize){
        if(indexControl+1 != listSize)
            stringBuilder.append(",");

        if((indexControl+1) % listSize == 0)
            stringBuilder.append("\n");
    }


    public static void doSingleLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize, int elementCount){
        if(elementCount < listSize*listSize )
            stringBuilder.append(",");
    }


}
