package com.league.league.backendchallenge.service;

import com.league.league.backendchallenge.service.impl.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {


    @InjectMocks
    ValidationServiceImpl validationService;


    @BeforeEach
    void setUp() {
    }

    @Test
    void isInputAnInteger() {

        String input = "5";
        boolean expected = true;

        boolean actual = validationService.isInputAnInteger(input);
        System.out.println(actual);
        assertThat(actual).isEqualTo(expected);
    }
}