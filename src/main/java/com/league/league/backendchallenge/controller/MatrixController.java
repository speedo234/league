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

    @PostMapping("/echo")
    public ResponseEntity<String> echo( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixGiven(file));
    }

    @PostMapping("/echoInverted")
    public ResponseEntity<String> echoInverted( @RequestPart("file") MultipartFile file ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(matrixService.doMatrixInverted(file));
    }


}
