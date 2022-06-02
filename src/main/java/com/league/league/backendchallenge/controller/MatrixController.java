package com.league.league.backendchallenge.controller;


import com.league.league.backendchallenge.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MatrixController {


    @Autowired
    MatrixService matrixService;


    @PostMapping("/echo")
    public ResponseEntity<String> echo( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixGiven(file));
    }


    @PostMapping("/echoInverted")
    public ResponseEntity<String> echoInverted( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixInverted(file));
    }


    @PostMapping("/echoFlatten")
    public ResponseEntity<String> echoFlatten( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixFlatten(file));
    }



    @PostMapping("/echoSum")
    public ResponseEntity<Long> echoSum( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixSum(file));
    }


    @PostMapping("/echoMultiply")
    public ResponseEntity<Long> echoMultiply( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixMultiply(file));
    }


}
