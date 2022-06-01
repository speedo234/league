package com.league.league.backendchallenge.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class MatrixServiceImplTest {


    FileInputStream inputFile;
    MockMultipartFile file;

    @InjectMocks
    MatrixServiceImpl matrixService;

    @Mock
    ValidationServiceImpl validationService;

    @Mock
    ResponseServiceImpl responseService;

    private List<List<Integer>> integerList1;

    @BeforeEach
    void setUp() throws IOException {
        inputFile = new FileInputStream( "C:/Users/ibren/gitrepositories/java projects/league/src/main/resources/matrix.csv");
        file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);

        integerList1 = new ArrayList<>();
        List<Integer> integerList = Arrays.asList(1,2,3);
        integerList1.add(integerList);
        integerList = Arrays.asList(4,5,6);
        integerList1.add(integerList);
        integerList = Arrays.asList(7,8,9);
        integerList1.add(integerList);
    }

    @Test
    void doMatrixGiven() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,2,3");
        stringBuilder.append("\n");
        stringBuilder.append("4,5,6");
        stringBuilder.append("\n");
        stringBuilder.append("7,8,9");
        stringBuilder.append("\n");
        stringBuilder.append("```");

        String expected = stringBuilder.toString();

        when(validationService.isValidMatrixFormat( Mockito.anyList() )).thenReturn(true);
        when(validationService.isInputAnInteger( Mockito.anyString() )).thenReturn(true);
        when(responseService.doMatrixFormatString(integerList1)).thenReturn(expected);
        String actual = matrixService.doMatrixGiven(file);
        assertThat( actual ).isEqualTo(expected);
    }

    @Test
    void doMatrixInverted() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,4,7");
        stringBuilder.append("\n");
        stringBuilder.append("2,5,8");
        stringBuilder.append("\n");
        stringBuilder.append("3,6,9");
        stringBuilder.append("\n");
        stringBuilder.append("```");

        String expected = stringBuilder.toString();

        when(validationService.isValidMatrixFormat( Mockito.anyList() )).thenReturn(true);
        when(validationService.isInputAnInteger(Mockito.anyString())).thenReturn(true);
        when(responseService.doMatrixFormatStringInverted(integerList1)).thenReturn(expected);
        String actual = matrixService.doMatrixInverted(file);
        assertThat( actual ).isEqualTo(expected);
    }

    @Test
    void doMatrixFlatten() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,2,3,4,5,6,7,8,9");
        stringBuilder.append("\n");
        stringBuilder.append("```");

        String expected = stringBuilder.toString();

        when(validationService.isValidMatrixFormat( Mockito.anyList() )).thenReturn(true);
        when(validationService.isInputAnInteger(Mockito.anyString())).thenReturn(true);
        when(responseService.doMatrixFormatStringFlatten(integerList1)).thenReturn(expected);
        String actual = matrixService.doMatrixFlatten(file);
        System.out.println(actual);
        assertThat( actual ).isEqualTo(expected);
    }

    @Test
    void doMatrixSum() throws IOException {

        int expected = 45;

        when(validationService.isValidMatrixFormat( Mockito.anyList() )).thenReturn(true);
        when(validationService.isInputAnInteger(Mockito.anyString())).thenReturn(true);
        when(responseService.doMatrixSum( integerList1 )).thenReturn(expected);
        int actual = matrixService.doMatrixSum(file);
        assertThat( actual ).isEqualTo(expected);
    }

    @Test
    void doMatrixMultiply() throws IOException {

        int expected = 362880;

        when(validationService.isValidMatrixFormat( Mockito.anyList() )).thenReturn(true);
        when(validationService.isInputAnInteger(Mockito.anyString())).thenReturn(true);
        when(responseService.doMatrixMultiply(integerList1)).thenReturn(expected);
        int actual = matrixService.doMatrixMultiply(file);
        System.out.println(actual);
        assertThat( actual ).isEqualTo(expected);
    }
}