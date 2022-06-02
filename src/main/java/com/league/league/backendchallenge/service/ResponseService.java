package com.league.league.backendchallenge.service;


import java.util.List;


public interface ResponseService {


    String doMatrixFormatString(List<List<Integer>> integerList1);


    String doMatrixFormatStringInverted(List<List<Integer>> integerList1);

    String doMatrixFormatStringFlatten(List<List<Integer>> integerList1);


    Long doMatrixSum(List<List<Integer>> integerList1);


    Long doMatrixMultiply(List<List<Integer>> integerList1);



}
