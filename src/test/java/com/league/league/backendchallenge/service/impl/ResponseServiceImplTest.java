package com.league.league.backendchallenge.service.impl;

import io.swagger.models.auth.In;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class ResponseServiceImplTest {


    @InjectMocks
    ResponseServiceImpl responseService;

    private List<List<Integer>> integerList1;


    @BeforeEach
    void setUp() {
        integerList1 = new ArrayList<>();
        List<Integer> integerList = Arrays.asList(1,2,3);
        integerList1.add(integerList);
        integerList = Arrays.asList(4,5,6);
        integerList1.add(integerList);
        integerList = Arrays.asList(7,8,9);
        integerList1.add(integerList);
    }

    @Test
    void doMatrixFormatString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,2,3");
        stringBuilder.append("\n");
        stringBuilder.append("4,5,6");
        stringBuilder.append("\n");
        stringBuilder.append("7,8,9");
        stringBuilder.append("\n");
        stringBuilder.append("```");

        String expected = stringBuilder.toString();

        String actual = responseService.doMatrixFormatString(integerList1);

        assertThat(actual).isEqualTo( expected );
    }

    @Test
    void doMatrixFormatStringInverted() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,4,7");
        stringBuilder.append("\n");
        stringBuilder.append("2,5,8");
        stringBuilder.append("\n");
        stringBuilder.append("3,6,9");
        stringBuilder.append("\n");
        stringBuilder.append("```");

        String expected = stringBuilder.toString();

        String actual = responseService.doMatrixFormatStringInverted(integerList1);

        assertThat(actual).isEqualTo( expected );
    }

    @Test
    void doMatrixFormatStringFlatten() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,2,3,4,5,6,7,8,9");
        stringBuilder.append("\n");
        stringBuilder.append("```");

        String expected = stringBuilder.toString();

        String actual = responseService.doMatrixFormatStringFlatten(integerList1);

        assertThat(actual).isEqualTo( expected );

    }

    @Test
    void doMatrixSum() {

        Long expected = 45L;

        Long actual = responseService.doMatrixSum(integerList1);

        assertThat(actual).isEqualTo( expected );
    }

    @Test
    void doMatrixMultiply() {

        int expected = 362880;

        Long actual = responseService.doMatrixMultiply(integerList1);

        assertThat(actual).isEqualTo( expected );
    }
}