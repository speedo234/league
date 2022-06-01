package com.league.league.backendchallenge.service;

import com.league.league.backendchallenge.service.impl.ValidationServiceImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {


    FileInputStream inputFile;
    MockMultipartFile file;

    @InjectMocks
    ValidationServiceImpl validationService;


    @BeforeEach
    void setUp() throws IOException {
        inputFile = new FileInputStream( "C:/Users/ibren/gitrepositories/java projects/league/src/main/resources/matrix.csv");
        file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);
    }

    @Test
    void isInputAnInteger() {

        String input = "5";
        boolean expected = true;

        boolean actual = validationService.isInputAnInteger(input);
        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }


    @Test
    void isValidMatrixFormat() throws IOException {

        CSVParser records = CSVFormat.EXCEL.parse(new InputStreamReader(file.getInputStream()));
        List<CSVRecord> csvRecordList = records.getRecords();
        boolean expected = true;

        boolean actual = validationService.isValidMatrixFormat(csvRecordList);
        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }

}