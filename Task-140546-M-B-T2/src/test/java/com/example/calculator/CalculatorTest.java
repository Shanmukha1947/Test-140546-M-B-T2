package com.example.calculator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @InjectMocks
    private Calculator calculator;

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "4, -5, -20",
            "-1, 7, -7",
            "0, 10, 0",
            "10, 0, 0"
    })
    public void testMultiply(int a, int b, int expectedResult) {
        // No additional mocking is required for the multiply method since it doesn't interact with any external objects.
        int actualResult = calculator.multiply(a, b);
        Mockito.verifyNoMoreInteractions(calculator); // Verify that no other methods were called on the calculator mock.
        assertEquals(expectedResult, actualResult);
    }
}

