package com.league.league.backendchallenge.service;


import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MatrixService {


    public String doMatrixGiven(MultipartFile file) throws IOException;

    public String doMatrixInverted(MultipartFile file) throws IOException;


}
