package com.league.league.backendchallenge.service;


import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface ResponseService {


//    @Autowired
//    ValidationService validationService;


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


    String doMatrixFormatString(List<List<Integer>> integerList1);


    String doMatrixFormatStringInverted(List<List<Integer>> integerList1);

    String doMatrixFormatStringFlatten(List<List<Integer>> integerList1);


    int doMatrixSum(List<List<Integer>> integerList1);


    int doMatrixMultiply(List<List<Integer>> integerList1);



//    public static void printMatrix(List<List<Integer>> integerList1){
//        for(List<Integer> integerList :integerList1){
//            System.out.println(integerList);
//        }
//    }
//
//
//    private static void doLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize){
//        if(indexControl+1 != listSize)
//            stringBuilder.append(",");
//
//        if((indexControl+1) % listSize == 0)
//            stringBuilder.append("\n");
//    }
//
//
//    private static void doSingleLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize, int elementCount){
//        if(elementCount < listSize*listSize )
//            stringBuilder.append(",");
//    }
//
//
//    public static int getMatrixSize(List<CSVRecord> csvRecordList){
//        return csvRecordList.size();
//    }


}
