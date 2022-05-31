package com.league.league.backendchallenge.service;


import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MatrixService {


    String doMatrixGiven(MultipartFile file) throws IOException;

    String doMatrixInverted(MultipartFile file) throws IOException;

    String doMatrixFlatten(MultipartFile file) throws IOException;

    int doMatrixSum(MultipartFile file) throws IOException;


}
