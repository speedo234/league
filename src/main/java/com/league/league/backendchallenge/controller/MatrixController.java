package com.league.league.backendchallenge.controller;


import com.league.league.backendchallenge.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class MatrixController {


    @Autowired
    MatrixService matrixService;

    /*
    * 1. Echo (given)
    - Return the matrix as a string in matrix format.
    * */
    @PostMapping("/echo")
    public ResponseEntity<String> echo( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixGiven(file));
    }

    /*
    * 2. Invert
    - Return the matrix as a string in matrix format where the columns and rows are inverted
    * */
    @PostMapping("/echoInverted")
    public ResponseEntity<String> echoInverted( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixInverted(file));
    }

    /*
    * 3. Flatten
    - Return the matrix as a 1 line string, with values separated by commas.
    * */
    @PostMapping("/echoFlatten")
    public ResponseEntity<String> echoFlatten( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixFlatten(file));
    }

    /*
    * 4. Sum
    - Return the sum of the integers in the matrix
    * */
    @PostMapping("/echoSum")
    public ResponseEntity<?> echoSum( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixSum(file));
    }


}
