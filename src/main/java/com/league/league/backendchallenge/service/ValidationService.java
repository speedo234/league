package com.league.league.backendchallenge.service;


import org.springframework.stereotype.Service;

import java.util.List;



public interface ValidationService {



    boolean isInputAnInteger( String number );

    boolean isValidMatrixFormat( List<List<Integer>> integerList1 );

}
