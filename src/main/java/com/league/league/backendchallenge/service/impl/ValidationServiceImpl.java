package com.league.league.backendchallenge.service.impl;


import com.league.league.backendchallenge.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidationServiceImpl implements ValidationService {



    public boolean isInputAnInteger( String number ){
        try{
            Integer.parseInt( number );
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }

    }

    @Override
    public boolean isValidMatrixFormat(List<List<Integer>> integerList1) {
        return integerList1.size() == integerList1.get(0).size();
    }

}
