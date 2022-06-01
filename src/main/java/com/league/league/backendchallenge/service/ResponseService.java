package com.league.league.backendchallenge.service;


import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface ResponseService {


    String doMatrixFormatString(List<List<Integer>> integerList1);


    String doMatrixFormatStringInverted(List<List<Integer>> integerList1);

    String doMatrixFormatStringFlatten(List<List<Integer>> integerList1);


    int doMatrixSum(List<List<Integer>> integerList1);


    int doMatrixMultiply(List<List<Integer>> integerList1);



}
