package com.epam.testing.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void testAdd() {
        assertEquals(3, calculator.add(1, 2));
    }

}
