package com.league.league.backendchallenge.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class MatrixUtil {


    static final Logger logger = LoggerFactory.getLogger(MatrixUtil.class);


    private MatrixUtil() {
    }

    public static void printMatrix(List<List<Integer>> integerList1){
        for(List<Integer> integerList :integerList1){
            logger.info("{}",integerList);
        }
    }


    public static void doMultiLineProcessor(StringBuilder stringBuilder, int indexControl, int listSize){
        if(indexControl+1 != listSize)
            stringBuilder.append(",");

        if((indexControl+1) % listSize == 0)
            stringBuilder.append("\n");
    }


    public static void doSingleLineProcessor(StringBuilder stringBuilder, int listSize, int elementCount){
        if(elementCount < listSize*listSize )
            stringBuilder.append(",");
    }


}
