package com.league.league.backendchallenge.service.impl;


import com.league.league.backendchallenge.service.ValidationService;
import org.springframework.stereotype.Service;


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

}
