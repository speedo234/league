package com.league.league.backendchallenge.service;


import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ValidationService {



    boolean isInputAnInteger( String number );

    boolean isValidMatrixFormat( List<CSVRecord> csvRecordList );

}
