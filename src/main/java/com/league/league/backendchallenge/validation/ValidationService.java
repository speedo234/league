package com.league.league.backendchallenge.validation;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidationService {



    public static boolean isInputInteger( String number ){
        try{
            Integer.parseInt( number );
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }

    }

}
